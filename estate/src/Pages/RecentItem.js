import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './RecentItem.css'; // 외부 스타일 시트 불러오기
import Aside from '../Components/Aside';

const RecentItem = () => {
  const [recentProducts, setRecentProducts] = useState([]);

  useEffect(() => {
    const fetchRecentProducts = async () => {
      try {
        const userCode = sessionStorage.getItem('userCode');
        if (userCode) {
          const response = await axios.get(
            `http://localhost:8000/getViewedProduct/${userCode}`,
          );
          // 중복을 제거하기 위해 set을 사용하여 유니크한 상품만 추출
          const uniqueProducts = Array.from(
            new Set(
              response.data.map((product) => product.product.productCode),
            ),
          ).map((productCode) => {
            // 중복 제거된 제품 코드에 해당하는 상품 반환
            return response.data.find(
              (product) => product.product.productCode === productCode,
            );
          });

          // 상위 10개만 가져옴
          setRecentProducts(uniqueProducts.slice(0, 10));
        } else {
          alert('사용자 코드가 없습니다.');
        }
      } catch (error) {
        console.error('최근 본 상품을 불러오는 중 오류 발생:', error);
      }
    };

    fetchRecentProducts();
  }, []);

  return (
    <div className="page">
      <Aside />
      <article>
        <h2>최근 본 상품</h2>
      </article>
      <section>
        <table>
          <thead>
            <tr>
              <th>상품정보</th>
            </tr>
          </thead>
          <tbody>
            {recentProducts.map((product) => (
              <tr key={product.viewCode}>
                <td>
                  <img
                    src={`http://localhost:8000/getProductImage/${product.product.productCode}`}
                    alt={product.product.productName}
                    style={{ width: '100px', height: '100px' }}
                  />
                  <div>
                    <strong>{product.product.companyName}</strong>
                    <br />
                    {product.product.information}
                    <br />
                    옵션 : {product.product.productSize}
                  </div>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </section>
    </div>
  );
};

export default RecentItem;

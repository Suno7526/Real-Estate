import './Product.css'; // 외부 스타일 시트 불러오기
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';
import { BrowserRouter, Route, Routes, Link } from 'react-router-dom';

const Category = () => {
  const { category } = useParams();
  const [products, setProduct] = useState(null);
  useEffect(() => {
    const fetchProduct = async () => {
      try {
        let response;
        if (category === 'OUTER') {
          const jacket = await axios.get(`/category/재킷`);
          const jumper = await axios.get(`/category/집업`);
          const coat = await axios.get(`/category/점퍼`);
          const parka = await axios.get(`/category/코트`);
          const padding = await axios.get(`/category/패딩`);
          const paca = await axios.get(`/category/파카`);
          const mopi = await axios.get(`/category/모피`);
          const musang = await axios.get(`/category/머스탱`);
          response = [
            ...jacket.data,
            ...jumper.data,
            ...coat.data,
            ...parka.data,
            ...padding.data,
            ...paca.data,
            ...mopi.data,
            ...musang.data,
          ];
        } else {
          response = await axios.get(`/category/${category}`);
        }
        // 정렬은 데이터를 받아온 후에 수행
        const sortedProducts = response.sort(
          (a, b) => b.viewCount - a.viewCount,
        );
        setProduct(sortedProducts);
      } catch (error) {
        console.error('상품을 불러오는 중 오류 발생:', error);
      }
    };

    fetchProduct();
  }, [category]);

  if (!products) {
    return <div>Loading...</div>;
  }

  const saveViewedProduct = async (userCode, productCode) => {
    try {
      await axios.post('http://localhost:8000/saveViewedProduct', {
        userCode: userCode,
        productCode: productCode,
      });
      console.log('상품을 성공적으로 저장했습니다.');
    } catch (error) {
      console.error('상품을 저장하는 중 오류 발생:', error);
    }
  };

  // 상품 클릭 시 호출되는 함수
  const handleClickProduct = (productCode) => {
    const userCode = sessionStorage.getItem('userCode');
    if (userCode) {
      saveViewedProduct(userCode, productCode);
    } else {
      console.log('사용자가 로그인되어 있지 않습니다.');
    }
  };

  return (
    <div>
      <div id="recommended-properties">
        <div className="best-item">Best Item</div>
        <div className="sub-best-item">조회수가 높은 아이템 👍</div>

        <div id="guides-properties">
          <div className="guides-section">
            {products.map((product, index) => (
              <div
                className="guides-card"
                data-rank={index + 1}
                key={product.productCode}
              >
                <Link to={`/product/${product.productCode}`}>
                  <img
                    src={`http://localhost:8000/getProductImage/${product.productCode}`}
                    alt={`코디 ${product.productCode}`}
                    className="property-image"
                    style={{
                      width: '12em',
                      height: '12em',
                    }}
                    onClick={() => handleClickProduct(product.productCode)}
                  />
                </Link>

                <div className="product-info">
                  <p>
                    <strong>상품명:</strong> {product.productName}
                  </p>
                  <p>
                    <strong>설명:</strong> {product.information}
                  </p>
                  <p>
                    <strong>회사명:</strong> {product.companyName}
                  </p>
                  <p>
                    <strong>재고:</strong> {product.productStuck}
                  </p>
                  <p>
                    <strong>제품 크기:</strong> {product.productSize}
                  </p>
                  <p>
                    <strong></strong> ₩{product.productPrice}
                  </p>
                  <p>
                    <strong>조회수:</strong> {product.viewCount}
                  </p>
                </div>
              </div>
            ))}
          </div>
        </div>
      </div>
    </div>
  );
};

export default Category;

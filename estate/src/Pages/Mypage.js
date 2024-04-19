import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './Mypage.css'; // 외부 스타일 시트 불러오기
import Aside from '../Components/Aside';

const Mypage = () => {
  const [ordersItems, setOrdersItems] = useState([]);

  // 사용자 주문 내역을 가져오는 함수
  const fetchOrders = async () => {
    try {
      const userCode = sessionStorage.getItem('userCode');
      // 사용자의 주문 내역을 가져오기 위해 요청을 보냅니다.
      const response = await axios.get(
        `http://localhost:8000/getOrdersProduct/${userCode}`,
      );
      // 가져온 주문 내역을 상태에 저장합니다.
      setOrdersItems(response.data);
    } catch (error) {
      console.error('주문 내역을 불러오는 중 오류 발생:', error);
    }
  };

  // 컴포넌트가 마운트될 때 주문 내역을 가져옵니다.
  useEffect(() => {
    fetchOrders();
  }, []);

  const formatRegisterDate = (dateString) => {
    const date = new Date(dateString);
    const year = date.getFullYear();
    const month = String(date.getMonth() + 1).padStart(2, '0');
    const day = String(date.getDate()).padStart(2, '0');
    return `${year}-${month}-${day}`;
  };

  return (
    <div className="page">
      <Aside />
      <article>
        <h2>주문내역 조회</h2>
        <ul>
          <li>주문내역에 관한 내용</li>
        </ul>
      </article>
      <section>
        <table>
          <thead>
            <tr>
              <th>상품정보</th>
              <th>주문일자</th>
              <th>주문번호</th>
              <th>주문금액</th>
              <th>배송주소</th>
            </tr>
          </thead>
          <tbody>
            {ordersItems.map((order) => (
              <tr key={order.orderCode}>
                <td>
                  <img
                    src={`http://localhost:8000/getProductImage/${order.product.productCode}`}
                    alt={order.product.productName}
                    style={{ width: '100px', height: '100px' }}
                  />
                  <div>
                    <strong>{order.product.productName}</strong>
                    <br />
                    옵션: {order.product.productOption}
                  </div>
                </td>
                <td>{formatRegisterDate(order.product.registerDate)}</td>
                <td>{order.orderCode}</td>
                <td>{order.product.productPrice}원</td>
                <td>{order.shippingAddress}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </section>
    </div>
  );
};

export default Mypage;

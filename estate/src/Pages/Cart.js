import React, { useEffect, useState } from 'react';
import './Cart.css';
import Header from '../Components/Header';
import axios from 'axios';

const Cart = () => {
  const [cartItems, setCartItems] = useState([]);

  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const response = await axios.get(
          `http://localhost:8000/getCartProduct/${sessionStorage.getItem(
            'userCode',
          )}`,
        );

        // 중복된 제품을 합치고 수량을 계산
        const uniqueProducts = [];
        response.data.forEach((item) => {
          const existingProduct = uniqueProducts.find(
            (product) => product.productCode === item.product.productCode,
          );

          if (existingProduct) {
            existingProduct.quantity += 1;
          } else {
            uniqueProducts.push({ ...item.product, quantity: 1 });
          }
        });

        setCartItems(uniqueProducts);
      } catch (error) {
        console.error('상품을 불러오는 중 오류 발생:', error);
      }
    };

    fetchProducts();
  }, []);

  return (
    <div>
      <div id="cart">
        <h2>장바구니</h2>
        {cartItems && cartItems.length > 0 ? (
          cartItems.map((item) => (
            <div className="product-line" key={item.productCode}>
              <img
                src={`http://localhost:8000/getProductImage/${item.productCode}`}
                alt=""
                className="product-image"
              />
              <div className="product-details">
                <p>{item.productName}</p>
                <p>{item.productPrice}</p>
                <p>수량: {item.quantity}</p>
                <p>총 가격: {item.productPrice * item.quantity}</p>
              </div>
              <button className="delete-item-btn">X</button>
            </div>
          ))
        ) : (
          <p>장바구니가 비어 있습니다.</p>
        )}
      </div>
      <footer>
        <p>© 기타 문의 바람.</p>
      </footer>
    </div>
  );
};

export default Cart;

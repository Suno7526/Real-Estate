import React from 'react';
import './Modal.css';

const Modal = ({ isOpen, onClose, selectedOptions, product }) => {
  return (
    <>
      {isOpen && (
        <div className="modal">
          <div className="modal-content">
            <span className="close" onClick={onClose}>
              &times;
            </span>
            <b>정보가 맞는지 확인해주세요!😊</b>
            <hr></hr>
            <p>주소: {selectedOptions.address}</p>
            <p>사이즈: {selectedOptions.size}</p>
            <p>가격: {product.productPrice}</p>
          </div>
        </div>
      )}
    </>
  );
};

export default Modal;

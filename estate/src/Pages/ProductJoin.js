import React from 'react';
import axios from 'axios';
import { useState, useEffect } from 'react';
import './ProductJoin.css';

const ProductJoin = () => {
  const [productData, setProductData] = useState({
    productName: '',
    information: '',
    productPrice: '',
    companyName: '',
    productStuck: '',
    productSize: '',
    category: '',
  });

  const [productImage, setProductImage] = useState(null);
  const [previewImage, setPreviewImage] = useState(null);

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setProductData({ ...productData, [name]: value });
  };

  const handleFileChange = (e) => {
    const imageFile = e.target.files[0];
    setProductImage(imageFile);
    setPreviewImage(URL.createObjectURL(imageFile));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      if (
        !productData.productName ||
        !productData.information ||
        !productData.productPrice ||
        !productData.companyName ||
        !productData.productStuck ||
        !productData.productSize ||
        !productData.category ||
        !productImage
      ) {
        alert(
          '상품명, 설명, 가격, 회사명, 재고, 제품 크기, 사용자 포인트, 그리고 이미지를 모두 입력해주세요.',
        );
        return;
      }

      const formData = new FormData();
      formData.append('productName', productData.productName);
      formData.append('information', productData.information);
      formData.append('productPrice', productData.productPrice);
      formData.append('companyName', productData.companyName);
      formData.append('productStuck', productData.productStuck);
      formData.append('productSize', productData.productSize);
      formData.append('category', productData.category);
      formData.append('productImage', productImage);

      const response = await axios.post(
        'http://localhost:8000/saveProduct',
        formData,
        {
          headers: {
            'Content-Type': 'multipart/form-data',
          },
        },
      );

      console.log(response.data);
      alert('상품 등록 성공');
    } catch (error) {
      alert('상품 등록 실패');
      console.error('상품 저장 오류:', error);
    }
  };

  return (
    <div className="App">
      <div id="property-form">
        <form encType="multipart/form-data">
          <label htmlFor="productName">상품명:</label>
          <input
            type="text"
            id="productName"
            name="productName" // 수정: 프로퍼티 이름을 name으로 변경
            value={productData.productName} // 수정: 프로퍼티 이름을 name으로 변경
            onChange={handleInputChange}
          />

          <label htmlFor="information">설명:</label>
          <input
            type="text"
            id="information"
            name="information"
            value={productData.information}
            onChange={handleInputChange}
          />

          <label htmlFor="productPrice">가격:</label>
          <input
            type="text"
            id="productPrice"
            name="productPrice" // 수정: 프로퍼티 이름을 price로 변경
            value={productData.productPrice} // 수정: 프로퍼티 이름을 price로 변경
            onChange={handleInputChange}
          />

          <label htmlFor="companyName">회사명:</label>
          <input
            type="text"
            id="companyName"
            name="companyName"
            value={productData.companyName}
            onChange={handleInputChange}
          />

          <label htmlFor="productStuck">재고:</label>
          <input
            type="text"
            id="productStuck"
            name="productStuck"
            value={productData.productStuck}
            onChange={handleInputChange}
          />
          <label htmlFor="productSize">제품 크기:</label>
          <input
            type="text"
            id="productSize"
            name="productSize"
            value={productData.productSize}
            onChange={handleInputChange}
          />
          <label htmlFor="category">카테고리:</label>
          <input
            type="text"
            id="category"
            name="category"
            value={productData.category}
            onChange={handleInputChange}
          />

          <div id="property-details">
            <label htmlFor="productImage">사진 업로드:</label>
            <input
              type="file"
              id="productImage"
              name="productImage"
              accept="image/*"
              onChange={handleFileChange}
            />
            {previewImage && (
              <img
                src={previewImage}
                alt="이미지 미리보기"
                style={{ width: '200px', height: '200px', marginTop: '10px' }}
              />
            )}
          </div>

          <button type="button" onClick={handleSubmit}>
            상품 등록
          </button>
        </form>
      </div>
    </div>
  );
};

export default ProductJoin;

import React from 'react';
import { Link } from 'react-router-dom'; // Link import 추가

const Aside = () => {
  return (
    <div>
      <nav>
        <ul></ul>
      </nav>
      <hr />
      <aside className="sidebar">
        <nav>
          <Link to="/RecentItem">
            <button>최근 본 상품</button>
          </Link>{' '}
          <Link to="/Like">
            <button>찜한 상품</button>
          </Link>{' '}
          <Link to="/Mypage">
            <button>주문 내역</button>
          </Link>{' '}
          <Link to="/Question">
            <button>문의 하기</button>
          </Link>{' '}
        </nav>
      </aside>
    </div>
  );
};

export default Aside;

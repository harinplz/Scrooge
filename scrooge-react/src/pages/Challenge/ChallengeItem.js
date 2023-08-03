import { Link } from "react-router-dom";

import styles from "./ChallengeItem.module.css";

const ChallengeItem = (props) => {
  return (
    <div className={styles.container}>
      <div className={styles.item_top}>
        <div className={styles.img_contianer}>
          <img src={`${process.env.PUBLIC_URL}/images/dummy.png`} alt="더미" />
        </div>
        <div className={styles.text_container}>
          <p className={styles.title}>{props.title}</p>
          <p>참여인원: 6 / 10명</p>
          <p>#일주일</p>
        </div>
      </div>
      <Link to="/challenge/join">
        <button>참여하기</button>
      </Link>
    </div>
  );
};

export default ChallengeItem;
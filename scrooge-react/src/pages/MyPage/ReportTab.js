import React, { useState } from "react";
import styles from "./ReportTab.module.css";
import ReportWeek from "./ReportWeek";

export default function ReportTab() {
  const [currentTab, setCurrentTab] = useState(1);

  const tabs = [
    {
      id: 1,
      tabTitle: '주간',
      content: <ReportWeek />,
    },
    {
      id: 2,
      tabTitle: '월간',
      content:'월간 리포트 입니다.',
    }
  ]

  const handleTabClick = (e) => {
    setCurrentTab(Number(e.target.id))
  }
  return (
    <div className={styles.tabContainer}>
      {/* 탭 버튼 */}
      <div className={styles.tabs}>
        {tabs.map((tab, i) => 
          <button
            key={i}
            id={tab.id}
            disabled={currentTab === tab.id}
            onClick={handleTabClick}
          >
            {tab.tabTitle}
          </button>
        )}
      </div>
      {/* 해당 내용 */}
      <div className={styles.content}>
        {tabs.map((tab, i) =>
          <div key={i}>
            {currentTab === tab.id &&
              <div>
                <p>{tab.content}</p>
              </div>
            }
          </div>
        )}
      </div>
    </div>
  )
}
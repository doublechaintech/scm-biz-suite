import { Button, Drawer, Modal } from 'antd';
import React, { forwardRef, useState } from 'react';
import _ from 'lodash';
import HTMLEditor from '../HTMLEditor';
import styles from './index.less';


function RichEditInput(props) {
  const [drawerVisible, setDrawerVisible] = useState(false);
  const [tipPopupVisible, setTipPopupVisible] = useState(false);
  const [content, setContent] = useState();

  const { value, onChange } = props;


  const showDrawer = () => setDrawerVisible(true);
  const closeDrawer = () => setDrawerVisible(false);
  const showTipsPopup = () => setTipPopupVisible(true);
  const closeTipsPopup = () => setTipPopupVisible(false);
  const resetValue = () => setContent(value);
  const isTheContentChange = () => _.isString(content) && !_.isEmpty(content) && value !== content;

  const handleCloseDrawer = () => {
    if (isTheContentChange()) {
      showTipsPopup();
      return;
    }
    closeDrawer();

  };

  const handleSave = () => {
    if (onChange instanceof Function) {
      onChange(content);
      closeTipsPopup();
      closeDrawer();
    }
  };

  const handleCancel = () => {
    resetValue();
    closeTipsPopup();
    closeDrawer();
  };


  const theContent = content || value;

  return (
    <div className={styles.richEditInput}>
      <div className={styles.contentPreview}>
        <div className={styles.contentPreviewTxt} >
          <div dangerouslySetInnerHTML={{ __html: value }} />
        </div>
        <Button className={styles.contentEditButton} type='dashed' icon='edit' onClick={showDrawer}>编辑</Button>
      </div>

      <input style={{ display: 'none' }} value={value} />

      <Modal
        visible={tipPopupVisible}
        title='取消编辑'
        onCancel={closeTipsPopup}
        footer={[
          <Button onClick={closeTipsPopup}>取消</Button>,
          <Button type='primary' onClick={handleSave}>保存</Button>,
          <Button type='danger' onClick={handleCancel}>放弃修改</Button>,
        ]}
      >
        内容未保存，是否放弃本次修改?
      </Modal>

      <Drawer
        title='编辑内容'
        placement='right'
        closable={false}
        visible={drawerVisible}
        width={720}
      >
        <HTMLEditor  value={theContent} onChange={setContent} />
        <div className={styles.popupDrawerActionList}>
          <Button onClick={handleSave} type='primary'>确定</Button>
          <Button onClick={handleCloseDrawer}>取消</Button>
        </div>
      </Drawer>
    </div>
  );
}

export default forwardRef(RichEditInput);

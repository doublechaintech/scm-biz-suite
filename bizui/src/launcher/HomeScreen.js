import FontAwesome from 'react-fontawesome';
import { Row, Col, Card, Table, Popconfirm, Button } from 'antd';

import React from 'react';

import TopMenu from './TopMenu';
import classNames from 'classnames';
//import BizRouter from './BizRouter'

import defaultLocaleName from './Launcher.locale';
const launcherLocaleName = defaultLocaleName; //you can define your version here to replace default

import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import styles from './HomeScreen.less';

import { Layout } from 'antd';

const { Content, Footer } = Layout;

class HomeScreen extends React.Component {
  gotoApp = (e, app) => {
    console.log('click ', app.id);
    const dispatch = this.props.dispatch;
    dispatch({ type: 'launcher/gotoApp', payload: { app } });
  };

  appList = () => {
    return (
      <div>
        <FontAwesome name="user" />
      </div>
    );
  };

  lowercaseFirst = stringExpr => {
    if (typeof stringExpr != 'string') {
      throw 'parameter stringExpr is not a string';
    }
    //let stringExpr="";
    if (stringExpr.length <= 0) {
      return '';
    }
    if (stringExpr.length == 1) {
      return stringExpr.substring(0, 1);
    }
    return stringExpr.substring(0, 1).toLowerCase() + stringExpr.substring(1);
  };

  calcLink = link => {
    let theCamelForm = this.lowercaseFirst(link);
    console.log('processing: ' + theCamelForm);
    return theCamelForm + 'App/dash';
    //return '/login';
  };

  showAppList = () =>{
    const styleList = 'icon-effect-1 icon-effect-1a icon-item'
    
    var effectClasses = classNames({
      styleList,
    });

    if(!this.props.launcher.data || !this.props.launcher.data.userAppList){
      return (
      <Row key="3" className="icon-item-list" justify="center" align="middle" id="more">
        <Col
          className={styleList}
          key={i}
          span={6}
          style={{ textAlign: 'center' }}
          onClick={e => this.gotoApp(e, app)}
        >
         登录成功，但是没有分配到任何App
        </Col>

    </Row>)
    }

    const appList = this.props.launcher.data.userAppList;

    return(<Row key="3" className="icon-item-list" justify="center" align="middle" id="more">
          {appList.map((app, i) => (
            <Col
              className={styleList}
              key={i}
              span={6}
              style={{ textAlign: 'center' }}
              onClick={e => this.gotoApp(e, app)}
            >
              <div className="icon-item-box">
                <FontAwesome name={app.appIcon} style={{ color: 'brown' }} className={'icon'} />
                <p>{app.title}</p>
              </div>
            </Col>
          ))}
        </Row>)



  }

  render() {
    

    const appList = this.props.launcher.data.userAppList;
    const calcLink = this.calcLink;

    const { systemName } = this.props.launcher;
    const userContext = this.props.launcher.data;
    

    // console.log(styleList);

    


    return (
      <div className={'wrapper'}>
        <Row key="1">
          <Col className="gutter-row" span={24}>
            <span className="logo" />
            <TopMenu {...this.props} />
          </Col>
        </Row>
        <Row key="2">
          <Col className="gutter-row heading" span={24}>
            <h1>{systemName}</h1>
            <div className="desc" />
            <a href="#more" className="btn">
              {launcherLocaleName(userContext, 'MoreFeatures')}
            </a>
          </Col>
        </Row>

        {this.showAppList()}

       
      </div>
    );
  }
}

const mapStateToProps = state => {
  return state;
};
const mapDispatchToProps = dispatch => ({
  receiveData: bindActionCreators({}, dispatch),
});

//export default connect(mapStateToProps, mapDispatchToProps)(UserSkillBizApp);
export default connect(mapStateToProps)(HomeScreen);

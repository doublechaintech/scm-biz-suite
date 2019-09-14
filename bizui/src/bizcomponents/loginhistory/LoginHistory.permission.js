

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './LoginHistory.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}
const internalSummaryOf = (loginHistory,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{loginHistory.id}</Description> 
<Description term="登录时间">{ moment(loginHistory.loginTime).format('YYYY-MM-DD')}</Description> 
<Description term="来自IP">{loginHistory.fromIp}</Description> 
<Description term="描述">{loginHistory.description}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = loginHistory => {
  const {LoginHistoryBase} = GlobalComponents
  return <PermissionSetting targetObject={loginHistory}  targetObjectMeta={LoginHistoryBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class LoginHistoryPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  loginHistory = this.props.loginHistory
    const { id,displayName,  } = loginHistory
    const  returnURL = `/loginHistory/${id}/dashboard`
    const cardsData = {cardsName:"登录历史",cardsFor: "loginHistory",cardsSource: loginHistory,displayName,returnURL,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={internalRenderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
      {renderPermissionSetting(cardsData.cardsSource)}
      
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  loginHistory: state._loginHistory,
}))(Form.create()(LoginHistoryPermission))


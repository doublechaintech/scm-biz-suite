

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './SecUser.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (secUser,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{secUser.id}</Description> 
<Description term="Login">{secUser.login}</Description> 
<Description term="Mobile">{secUser.mobile}</Description> 
<Description term="Email">{secUser.email}</Description> 
<Description term="Pwd">{secUser.pwd}</Description> 
<Description term="Weixin Openid">{secUser.weixinOpenid}</Description> 
<Description term="Weixin Appid">{secUser.weixinAppid}</Description> 
<Description term="Access Token">{secUser.accessToken}</Description> 
<Description term="Verification Code">{secUser.verificationCode}</Description> 
<Description term="Verification Code Expire">{ moment(secUser.verificationCodeExpire).format('YYYY-MM-DD')}</Description> 
<Description term="Last Login Time">{ moment(secUser.lastLoginTime).format('YYYY-MM-DD')}</Description> 
<Description term="Current Status">{secUser.currentStatus}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = secUser => {
  const {SecUserBase} = GlobalComponents
  return <PermissionSetting targetObject={secUser}  targetObjectMeta={SecUserBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class SecUserPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  secUser = this.props.secUser;
    const { id,displayName, userAppCount, loginHistoryCount } = secUser
    const cardsData = {cardsName:"Sec User",cardsFor: "secUser",cardsSource: secUser,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={`${cardsData.cardsName}: ${displayName}`}
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
  secUser: state._secUser,
}))(Form.create()(SecUserPermission))


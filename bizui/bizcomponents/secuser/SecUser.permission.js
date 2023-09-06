

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
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

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}
const internalSummaryOf = (secUser,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{secUser.id}</Description> 
<Description term="登录名">{secUser.login}</Description> 
<Description term="手机">{secUser.mobile}</Description> 
<Description term="邮箱">{secUser.email}</Description> 
<Description term="密码">{secUser.pwd}</Description> 
<Description term="微信openId">{secUser.weixinOpenid}</Description> 
<Description term="微信应用ID">{secUser.weixinAppid}</Description> 
<Description term="访问令牌">{secUser.accessToken}</Description> 
<Description term="验证码">{secUser.verificationCode}</Description> 
<Description term="验证码有效期">{ moment(secUser.verificationCodeExpire).format('YYYY-MM-DD')}</Description> 
<Description term="最后登录时间">{ moment(secUser.lastLoginTime).format('YYYY-MM-DD')}</Description> 
	
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
    const  secUser = this.props.secUser
    const { id,displayName, userAppCount, loginHistoryCount, wechatWorkappIdentityCount, wechatMiniappIdentityCount, keyPairIdentityCount } = secUser
    const  returnURL = `/secUser/${id}/workbench`
    const cardsData = {cardsName:"安全用户",cardsFor: "secUser",cardsSource: secUser,displayName,returnURL,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={internalRenderTitle(cardsData,this)}
       
        wrapperClassName={styles.advancedForm}
      >
      
      {renderPermissionSetting(cardsData.cardsSource)}
      
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  secUser: state._secUser,
}))(Form.create()(SecUserPermission))


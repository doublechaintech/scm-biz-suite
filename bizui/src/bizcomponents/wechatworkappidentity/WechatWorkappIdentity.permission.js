

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './WechatWorkappIdentity.profile.less'
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
const internalSummaryOf = (wechatWorkappIdentity,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{wechatWorkappIdentity.id}</Description> 
<Description term="公司">{wechatWorkappIdentity.corpId}</Description> 
<Description term="用户">{wechatWorkappIdentity.userId}</Description> 
<Description term="创建时间">{ moment(wechatWorkappIdentity.createTime).format('YYYY-MM-DD')}</Description> 
<Description term="最后登录时间">{ moment(wechatWorkappIdentity.lastLoginTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = wechatWorkappIdentity => {
  const {WechatWorkappIdentityBase} = GlobalComponents
  return <PermissionSetting targetObject={wechatWorkappIdentity}  targetObjectMeta={WechatWorkappIdentityBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class WechatWorkappIdentityPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  wechatWorkappIdentity = this.props.wechatWorkappIdentity
    const { id,displayName,  } = wechatWorkappIdentity
    const  returnURL = `/wechatWorkappIdentity/${id}/workbench`
    const cardsData = {cardsName:"企业微信认证",cardsFor: "wechatWorkappIdentity",cardsSource: wechatWorkappIdentity,displayName,returnURL,
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
  wechatWorkappIdentity: state._wechatWorkappIdentity,
}))(Form.create()(WechatWorkappIdentityPermission))


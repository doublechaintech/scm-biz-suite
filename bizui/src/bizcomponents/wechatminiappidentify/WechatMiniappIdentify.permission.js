

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './WechatMiniappIdentify.profile.less'
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
const internalSummaryOf = (wechatMiniappIdentify,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{wechatMiniappIdentify.id}</Description> 
<Description term="开放Id">{wechatMiniappIdentify.openId}</Description> 
<Description term="应用程序Id">{wechatMiniappIdentify.appId}</Description> 
<Description term="创建时间">{ moment(wechatMiniappIdentify.createTime).format('YYYY-MM-DD')}</Description> 
<Description term="最后登录时间">{ moment(wechatMiniappIdentify.lastLoginTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = wechatMiniappIdentify => {
  const {WechatMiniappIdentifyBase} = GlobalComponents
  return <PermissionSetting targetObject={wechatMiniappIdentify}  targetObjectMeta={WechatMiniappIdentifyBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class WechatMiniappIdentifyPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  wechatMiniappIdentify = this.props.wechatMiniappIdentify
    const { id,displayName,  } = wechatMiniappIdentify
    const  returnURL = `/wechatMiniappIdentify/${id}/dashboard`
    const cardsData = {cardsName:"微信Miniapp识别",cardsFor: "wechatMiniappIdentify",cardsSource: wechatMiniappIdentify,displayName,returnURL,
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
  wechatMiniappIdentify: state._wechatMiniappIdentify,
}))(Form.create()(WechatMiniappIdentifyPermission))


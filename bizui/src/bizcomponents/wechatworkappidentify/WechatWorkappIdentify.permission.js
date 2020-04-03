

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './WechatWorkappIdentify.profile.less'
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
const internalSummaryOf = (wechatWorkappIdentify,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{wechatWorkappIdentify.id}</Description> 
<Description term="公司标识">{wechatWorkappIdentify.corpId}</Description> 
<Description term="用户Id">{wechatWorkappIdentify.userId}</Description> 
<Description term="创建时间">{ moment(wechatWorkappIdentify.createTime).format('YYYY-MM-DD')}</Description> 
<Description term="最后登录时间">{ moment(wechatWorkappIdentify.lastLoginTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = wechatWorkappIdentify => {
  const {WechatWorkappIdentifyBase} = GlobalComponents
  return <PermissionSetting targetObject={wechatWorkappIdentify}  targetObjectMeta={WechatWorkappIdentifyBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class WechatWorkappIdentifyPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  wechatWorkappIdentify = this.props.wechatWorkappIdentify
    const { id,displayName,  } = wechatWorkappIdentify
    const  returnURL = `/wechatWorkappIdentify/${id}/dashboard`
    const cardsData = {cardsName:"微信Workapp识别",cardsFor: "wechatWorkappIdentify",cardsSource: wechatWorkappIdentify,displayName,returnURL,
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
  wechatWorkappIdentify: state._wechatWorkappIdentify,
}))(Form.create()(WechatWorkappIdentifyPermission))


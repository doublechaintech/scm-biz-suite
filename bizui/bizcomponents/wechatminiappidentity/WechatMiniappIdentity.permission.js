

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './WechatMiniappIdentity.profile.less'
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
const internalSummaryOf = (wechatMiniappIdentity,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{wechatMiniappIdentity.id}</Description> 
<Description term="openId">{wechatMiniappIdentity.openId}</Description> 
<Description term="应用ID">{wechatMiniappIdentity.appId}</Description> 
<Description term="UnionID">{wechatMiniappIdentity.unionId}</Description> 
<Description term="创建时间">{ moment(wechatMiniappIdentity.createTime).format('YYYY-MM-DD')}</Description> 
<Description term="最后登录时间">{ moment(wechatMiniappIdentity.lastLoginTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = wechatMiniappIdentity => {
  const {WechatMiniappIdentityBase} = GlobalComponents
  return <PermissionSetting targetObject={wechatMiniappIdentity}  targetObjectMeta={WechatMiniappIdentityBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class WechatMiniappIdentityPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  wechatMiniappIdentity = this.props.wechatMiniappIdentity
    const { id,displayName,  } = wechatMiniappIdentity
    const  returnURL = `/wechatMiniappIdentity/${id}/workbench`
    const cardsData = {cardsName:"微信小程序认证",cardsFor: "wechatMiniappIdentity",cardsSource: wechatMiniappIdentity,displayName,returnURL,
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
  wechatMiniappIdentity: state._wechatMiniappIdentity,
}))(Form.create()(WechatMiniappIdentityPermission))


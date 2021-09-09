

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import BaseTool from '../../common/Base.tool'
import { Tag, Button, Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'
import {TagCloud} from '../../components/Charts'
import Trend from '../../components/Trend'
import NumberInfo from '../../components/NumberInfo'
import { getTimeDistance } from '../../utils/utils'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './SecUser.dashboard.less'
import DescriptionList from '../../components/DescriptionList';
import ImagePreview from '../../components/ImagePreview';
import GlobalComponents from '../../custcomponents';
import DashboardTool from '../../common/Dashboard.tool'
import appLocaleName from '../../common/Locale.tool'

const {aggregateDataset,calcKey, defaultHideCloseTrans,
  defaultImageListOf,defaultSettingListOf,defaultBuildTransferModal,
  defaultExecuteTrans,defaultHandleTransferSearch,defaultShowTransferModel,
  defaultRenderExtraHeader,
  defaultSubListsOf,defaultRenderAnalytics,
  defaultRenderExtraFooter,renderForTimeLine,renderForNumbers,
  defaultQuickFunctions, defaultRenderSubjectList,
}= DashboardTool

const {defaultFormatNumber} = BaseTool

const formatNumber = defaultFormatNumber

const { Description } = DescriptionList;
const { TabPane } = Tabs
const { RangePicker } = DatePicker
const { Option } = Select


const imageList =(secUser)=>{return [
	 ]}

const internalImageListOf = (secUser) =>defaultImageListOf(secUser,imageList)

const optionList =(secUser)=>{return [
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (secUser) =>defaultSettingListOf(secUser, optionList)
const internalLargeTextOf = (secUser) =>{

	return null


}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const renderSettingDropDown = (cardsData,targetComponent)=>{

  return (<div style={{float: 'right'}} >
        <Dropdown overlay={renderSettingMenu(cardsData,targetComponent)} placement="bottomRight" >

        <Button>
        <Icon type="setting" theme="filled" twoToneColor="#00b" style={{color:'#3333b0'}}/> 设置  <Icon type="down"/>
      </Button>
      </Dropdown></div>)

}

const renderSettingMenuItem = (item,cardsData,targetComponent) =>{

  const userContext = null
  return (<Menu.Item key={item.name}>
      <Link to={`/secUser/${targetComponent.props.secUser.id}/list/${item.name}/${item.displayName}/`}>
        <span>{item.displayName}</span>
        </Link>
        </Menu.Item>
  )

}
const renderSettingMenu = (cardsData,targetComponent) =>{

  const userContext = null
  return (<Menu>
    	<Menu.Item key="profile">
  			<Link to={`/secUser/${targetComponent.props.secUser.id}/permission`}><Icon type="safety-certificate" theme="twoTone" twoToneColor="#52c41a"/><span>{appLocaleName(userContext,"Permission")}</span></Link>
		</Menu.Item>
		<Menu.Divider />
		{cardsData.subSettingItems.map(item=>renderSettingMenuItem(item,cardsData,targetComponent))}
		</Menu>)

}

const internalRenderTitle = (cardsData,targetComponent) =>{


  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName} {renderSettingDropDown(cardsData,targetComponent)}</div>)

}


const internalSummaryOf = (cardsData,targetComponent) =>{

	 const quickFunctions = targetComponent.props.quickFunctions || internalQuickFunctions
	const secUser = cardsData.cardsSource
	const {SecUserService} = GlobalComponents
	const userContext = null
	return (
	<div>
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID" style={{wordBreak: 'break-all'}}>{secUser.id}</Description> 
<Description term="登录名" style={{wordBreak: 'break-all'}}>{secUser.login}</Description> 
<Description term="手机" style={{wordBreak: 'break-all'}}>{secUser.mobile}</Description> 
<Description term="邮箱" style={{wordBreak: 'break-all'}}>{secUser.email}</Description> 
<Description term="密码" style={{wordBreak: 'break-all'}}>{secUser.pwd}</Description> 
<Description term="微信openId" style={{wordBreak: 'break-all'}}>{secUser.weixinOpenid}</Description> 
<Description term="微信应用ID" style={{wordBreak: 'break-all'}}>{secUser.weixinAppid}</Description> 
<Description term="访问令牌" style={{wordBreak: 'break-all'}}>{secUser.accessToken}</Description> 
<Description term="验证码" style={{wordBreak: 'break-all'}}>{secUser.verificationCode}</Description> 
<Description term="验证码有效期">{ moment(secUser.verificationCodeExpire).format('YYYY-MM-DD HH:mm')}</Description> 
<Description term="最后登录时间">{ moment(secUser.lastLoginTime).format('YYYY-MM-DD HH:mm')}</Description> 

       
      </DescriptionList>
      <div>{quickFunctions(cardsData)}</div>
      </div>
	)

}


const renderTagCloud=(cardsData)=>{


  if(cardsData.subItems.length<10){
    return null
  }

  const tagValue = cardsData.subItems.map(item=>({name:item.displayName, value: item.count}))

  return <div >
      <div style={{verticalAlign:"middle",textAlign:"center",backgroundColor:"rgba(0, 0, 0, 0.65)",color:"white",fontWeight:"bold",height:"40px"}}>
       <span style={{display:"inline-block",marginTop:"10px"}}>{`${cardsData.displayName}画像`}</span>
      </div>
      <TagCloud data={tagValue} height={200} style={{backgroundColor:"white"}}/>
    </div>


}


const internalQuickFunctions = defaultQuickFunctions

class SecUserDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",
    defaultType: 'secUser'


  }
  componentDidMount() {

  }


  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, userAppListMetaInfo, loginHistoryListMetaInfo, wechatWorkappIdentityListMetaInfo, wechatMiniappIdentityListMetaInfo, keyPairIdentityListMetaInfo, userAppCount, loginHistoryCount, wechatWorkappIdentityCount, wechatMiniappIdentityCount, keyPairIdentityCount } = this.props.secUser
    if(!this.props.secUser.class){
      return null
    }
    const returnURL = this.props.returnURL

    const cardsData = {cardsName:window.trans('sec_user'),cardsFor: "secUser",
    	cardsSource: this.props.secUser,returnURL,displayName,
  		subItems: [
{name: 'userAppList', displayName: window.mtrans('user_app','sec_user.user_app_list',false) ,viewGroup:'__no_group', type:'userApp',count:userAppCount,addFunction: true, role: 'userApp', metaInfo: userAppListMetaInfo, renderItem: GlobalComponents.UserAppBase.renderItemOfList},
{name: 'loginHistoryList', displayName: window.mtrans('login_history','sec_user.login_history_list',false) ,viewGroup:'__no_group', type:'loginHistory',count:loginHistoryCount,addFunction: false, role: 'loginHistory', metaInfo: loginHistoryListMetaInfo, renderItem: GlobalComponents.LoginHistoryBase.renderItemOfList},
{name: 'wechatWorkappIdentityList', displayName: window.mtrans('wechat_workapp_identity','sec_user.wechat_workapp_identity_list',false) ,viewGroup:'__no_group', type:'wechatWorkappIdentity',count:wechatWorkappIdentityCount,addFunction: true, role: 'wechatWorkappIdentity', metaInfo: wechatWorkappIdentityListMetaInfo, renderItem: GlobalComponents.WechatWorkappIdentityBase.renderItemOfList},
{name: 'wechatMiniappIdentityList', displayName: window.mtrans('wechat_miniapp_identity','sec_user.wechat_miniapp_identity_list',false) ,viewGroup:'__no_group', type:'wechatMiniappIdentity',count:wechatMiniappIdentityCount,addFunction: true, role: 'wechatMiniappIdentity', metaInfo: wechatMiniappIdentityListMetaInfo, renderItem: GlobalComponents.WechatMiniappIdentityBase.renderItemOfList},
{name: 'keyPairIdentityList', displayName: window.mtrans('key_pair_identity','sec_user.key_pair_identity_list',false) ,viewGroup:'__no_group', type:'keyPairIdentity',count:keyPairIdentityCount,addFunction: true, role: 'keyPairIdentity', metaInfo: keyPairIdentityListMetaInfo, renderItem: GlobalComponents.KeyPairIdentityBase.renderItemOfList},

      	],
   		subSettingItems: [

      	],

  	};

    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const settingListOf = this.props.settingListOf || internalSettingListOf
    const imageListOf = this.props.imageListOf || internalImageListOf
    const subListsOf = this.props.subListsOf || internalSubListsOf
    const largeTextOf = this.props.largeTextOf ||internalLargeTextOf
    const summaryOf = this.props.summaryOf || internalSummaryOf
    const renderTitle = this.props.renderTitle || internalRenderTitle
    const renderExtraFooter = this.props.renderExtraFooter || internalRenderExtraFooter
    const renderAnalytics = this.props.renderAnalytics || defaultRenderAnalytics
    const quickFunctions = this.props.quickFunctions || internalQuickFunctions
    const renderSubjectList = this.props.renderSubjectList || internalRenderSubjectList
    // {quickFunctions(cardsData)}
    return (

      <PageHeaderLayout
        title={renderTitle(cardsData,this)}
        wrapperClassName={styles.advancedForm}
      >


       
     <Col span={24} style={{marginRight:"20px", backgroundColor: "white"}}>
      {renderTagCloud(cardsData)}

      {imageListOf(cardsData.cardsSource)}
      {renderAnalytics(cardsData.cardsSource)}
      {settingListOf(cardsData.cardsSource)}

	   </Col>

		 
      </PageHeaderLayout>

    )
  }
}

export default connect(state => ({
  secUser: state._secUser,
  returnURL: state.breadcrumb.returnURL,

}))(Form.create()(SecUserDashboard))




import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'
import {
  ChartCard, yuan, MiniArea, MiniBar, MiniProgress, Field, Bar, Pie, TimelineChart,
} from '../../components/Charts'
import Trend from '../../components/Trend'
import NumberInfo from '../../components/NumberInfo'
import { getTimeDistance } from '../../utils/utils'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './UserApp.dashboard.less'
import DescriptionList from '../../components/DescriptionList';
import ImagePreview from '../../components/ImagePreview';
import GlobalComponents from '../../custcomponents';
import DashboardTool from '../../common/Dashboard.tool'


const {aggregateDataset,calcKey, defaultHideCloseTrans,
  defaultImageListOf,defaultSettingListOf,defaultBuildTransferModal,
  defaultExecuteTrans,defaultHandleTransferSearch,defaultShowTransferModel,
  defaultRenderExtraHeader,
  defaultSubListsOf,
  defaultRenderExtraFooter,renderForTimeLine,renderForNumbers
}= DashboardTool



const { Description } = DescriptionList;
const { TabPane } = Tabs
const { RangePicker } = DatePicker
const { Option } = Select


const imageList =(userApp)=>{return [
	 ]}

const internalImageListOf = (userApp) =>defaultImageListOf(userApp,imageList)

const optionList =(userApp)=>{return [ 
	  {"title":'完全访问',"value":userApp.fullAccess,"parameterName":"fullAccess"},
]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (userApp) =>defaultSettingListOf(userApp, optionList)
const internalLargeTextOf = (userApp) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (userApp,targetComponent) =>{
	
	
	const {UserAppService} = GlobalComponents
	
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{userApp.id}</Description> 
<Description term="头衔">{userApp.title}</Description> 
<Description term="SEC的用户">{userApp.secUser==null?"未分配":userApp.secUser.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"SEC的用户","secUser",UserAppService.requestCandidateSecUser,
	      UserAppService.transferToAnotherSecUser,"anotherSecUserId",userApp.secUser?userApp.secUser.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="应用程序图标">{userApp.appIcon}</Description> 
<Description term="许可">{userApp.permission}</Description> 
<Description term="对象类型">{userApp.objectType}</Description> 
<Description term="对象ID">{userApp.objectId}</Description> 
<Description term="位置">{userApp.location}</Description> 
	
        {buildTransferModal(userApp,targetComponent)}
      </DescriptionList>
	)

}


class UserAppDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"城市",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'userApp'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, listAccessListMetaInfo, objectAccessListMetaInfo, listAccessCount, objectAccessCount } = this.props.userApp
    if(!this.props.userApp.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"用户应用程序",cardsFor: "userApp",
    	cardsSource: this.props.userApp,returnURL,displayName,
  		subItems: [
{name: 'listAccessList', displayName:'访问列表',type:'listAccess',count:listAccessCount,addFunction: true, role: 'listAccess', metaInfo: listAccessListMetaInfo},
{name: 'objectAccessList', displayName:'对象访问',type:'objectAccess',count:objectAccessCount,addFunction: true, role: 'objectAccess', metaInfo: objectAccessListMetaInfo},
    
      	],
  	};
    //下面各个渲染方法都可以定制，只要在每个模型的里面的_features="custom"就可以得到定制的例子
    
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const settingListOf = this.props.settingListOf || internalSettingListOf
    const imageListOf = this.props.imageListOf || internalImageListOf
    const subListsOf = this.props.subListsOf || internalSubListsOf
    const largeTextOf = this.props.largeTextOf ||internalLargeTextOf
    const summaryOf = this.props.summaryOf || internalSummaryOf
    const renderTitle = this.props.renderTitle || internalRenderTitle
    const renderExtraFooter = this.props.renderExtraFooter || internalRenderExtraFooter
    return (

      <PageHeaderLayout
        title={renderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
        <div>
        {settingListOf(cardsData.cardsSource)}
        {imageListOf(cardsData.cardsSource)}
        {subListsOf(cardsData)} 
        {largeTextOf(cardsData.cardsSource)}
          
        </div>
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  userApp: state._userApp,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(UserAppDashboard))


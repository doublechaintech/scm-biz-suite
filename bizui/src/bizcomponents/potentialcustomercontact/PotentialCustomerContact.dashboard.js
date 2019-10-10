

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Button, Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'
import {
  ChartCard, yuan, MiniArea, MiniBar, MiniProgress, Field, Bar, Pie, TimelineChart,
} from '../../components/Charts'
import Trend from '../../components/Trend'
import NumberInfo from '../../components/NumberInfo'
import { getTimeDistance } from '../../utils/utils'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './PotentialCustomerContact.dashboard.less'
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



const { Description } = DescriptionList;
const { TabPane } = Tabs
const { RangePicker } = DatePicker
const { Option } = Select


const imageList =(potentialCustomerContact)=>{return [
	 ]}

const internalImageListOf = (potentialCustomerContact) =>defaultImageListOf(potentialCustomerContact,imageList)

const optionList =(potentialCustomerContact)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (potentialCustomerContact) =>defaultSettingListOf(potentialCustomerContact, optionList)
const internalLargeTextOf = (potentialCustomerContact) =>{

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
      <Link to={`/potentialCustomerContact/${targetComponent.props.potentialCustomerContact.id}/list/${item.name}/${item.displayName}/`}>
        <span>{item.displayName}</span>
        </Link>
        </Menu.Item>
  )

}
const renderSettingMenu = (cardsData,targetComponent) =>{

  const userContext = null
  return (<Menu>
    	<Menu.Item key="profile">
  			<Link to={`/potentialCustomerContact/${targetComponent.props.potentialCustomerContact.id}/permission`}><Icon type="safety-certificate" theme="twoTone" twoToneColor="#52c41a"/><span>{appLocaleName(userContext,"Permission")}</span></Link>
		</Menu.Item>
		<Menu.Divider />
		{cardsData.subSettingItems.map(item=>renderSettingMenuItem(item,cardsData,targetComponent))}
		</Menu>)

}

const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName} {renderSettingDropDown(cardsData,targetComponent)}</div>)

}


const internalSummaryOf = (potentialCustomerContact,targetComponent) =>{
	
	
	const {PotentialCustomerContactService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{potentialCustomerContact.id}</Description> 
<Description term="名称">{potentialCustomerContact.name}</Description> 
<Description term="接触日期">{ moment(potentialCustomerContact.contactDate).format('YYYY-MM-DD')}</Description> 
<Description term="接触法">{potentialCustomerContact.contactMethod}</Description> 
<Description term="潜在的客户">{potentialCustomerContact.potentialCustomer==null?appLocaleName(userContext,"NotAssigned"):`${potentialCustomerContact.potentialCustomer.displayName}(${potentialCustomerContact.potentialCustomer.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"潜在的客户","potentialCustomer",PotentialCustomerContactService.requestCandidatePotentialCustomer,
	      PotentialCustomerContactService.transferToAnotherPotentialCustomer,"anotherPotentialCustomerId",potentialCustomerContact.potentialCustomer?potentialCustomerContact.potentialCustomer.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="城市合伙人">{potentialCustomerContact.cityPartner==null?appLocaleName(userContext,"NotAssigned"):`${potentialCustomerContact.cityPartner.displayName}(${potentialCustomerContact.cityPartner.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"城市合伙人","cityPartner",PotentialCustomerContactService.requestCandidateCityPartner,
	      PotentialCustomerContactService.transferToAnotherCityPartner,"anotherCityPartnerId",potentialCustomerContact.cityPartner?potentialCustomerContact.cityPartner.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="接触">{potentialCustomerContact.contactTo==null?appLocaleName(userContext,"NotAssigned"):`${potentialCustomerContact.contactTo.displayName}(${potentialCustomerContact.contactTo.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"接触","potentialCustomerContactPerson",PotentialCustomerContactService.requestCandidateContactTo,
	      PotentialCustomerContactService.transferToAnotherContactTo,"anotherContactToId",potentialCustomerContact.contactTo?potentialCustomerContact.contactTo.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="描述">{potentialCustomerContact.description}</Description> 
<Description term="最后更新时间">{ moment(potentialCustomerContact.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</Description> 
	
        {buildTransferModal(potentialCustomerContact,targetComponent)}
      </DescriptionList>
	)

}

const internalQuickFunctions = defaultQuickFunctions

class PotentialCustomerContactDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'potentialCustomerContact'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName,  } = this.props.potentialCustomerContact
    if(!this.props.potentialCustomerContact.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"潜在客户联系",cardsFor: "potentialCustomerContact",
    	cardsSource: this.props.potentialCustomerContact,returnURL,displayName,
  		subItems: [
    
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
    
    return (

      <PageHeaderLayout
        title={renderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
       
        {renderExtraHeader(cardsData.cardsSource)}
        {imageListOf(cardsData.cardsSource)}  
        {quickFunctions(cardsData)} 
        {renderAnalytics(cardsData.cardsSource)}
        {settingListOf(cardsData.cardsSource)}
        {renderSubjectList(cardsData)}       
        {largeTextOf(cardsData.cardsSource)}
        {renderExtraFooter(cardsData.cardsSource)}
  		
      </PageHeaderLayout>
    
    )
  }
}

export default connect(state => ({
  potentialCustomerContact: state._potentialCustomerContact,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(PotentialCustomerContactDashboard))


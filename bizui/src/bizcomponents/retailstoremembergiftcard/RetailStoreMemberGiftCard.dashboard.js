

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
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
import styles from './RetailStoreMemberGiftCard.dashboard.less'
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


const imageList =(retailStoreMemberGiftCard)=>{return [
	 ]}

const internalImageListOf = (retailStoreMemberGiftCard) =>defaultImageListOf(retailStoreMemberGiftCard,imageList)

const optionList =(retailStoreMemberGiftCard)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (retailStoreMemberGiftCard) =>defaultSettingListOf(retailStoreMemberGiftCard, optionList)
const internalLargeTextOf = (retailStoreMemberGiftCard) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const renderSettingDropDown = (cardsData,targetComponent)=>{

  return (<Dropdown overlay={renderSettingMenu(cardsData,targetComponent)} placement="bottomRight">
        <Icon
          type="setting"
        />
      </Dropdown>)


}

const renderSettingMenu = (cardsData,targetComponent) =>{

  const userContext = null
  return (<Menu>
    	<Menu.Item key="profile">
  			<Link to={`/retailStoreMemberGiftCard/${targetComponent.props.retailStoreMemberGiftCard.id}/permission`}><Icon type="safety-certificate" theme="twoTone" twoToneColor="#52c41a"/><span>{appLocaleName(userContext,"Permission")}</span></Link>
		</Menu.Item>
		<Menu.Item key="permission">
  			<Link to={`/retailStoreMemberGiftCard/${targetComponent.props.retailStoreMemberGiftCard.id}/profile`}><Icon type="cluster"  twoToneColor="#52c41a"/><span>{appLocaleName(userContext,"Profile")}</span></Link>
			</Menu.Item>
		</Menu>)

}

const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName} {renderSettingDropDown(cardsData,targetComponent)}</div>)

}


const internalSummaryOf = (retailStoreMemberGiftCard,targetComponent) =>{
	
	
	const {RetailStoreMemberGiftCardService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{retailStoreMemberGiftCard.id}</Description> 
<Description term="名称">{retailStoreMemberGiftCard.name}</Description> 
<Description term="业主">{retailStoreMemberGiftCard.owner==null?appLocaleName(userContext,"NotAssigned"):`${retailStoreMemberGiftCard.owner.displayName}(${retailStoreMemberGiftCard.owner.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"业主","retailStoreMember",RetailStoreMemberGiftCardService.requestCandidateOwner,
	      RetailStoreMemberGiftCardService.transferToAnotherOwner,"anotherOwnerId",retailStoreMemberGiftCard.owner?retailStoreMemberGiftCard.owner.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="数">{retailStoreMemberGiftCard.number}</Description> 
<Description term="保持">{retailStoreMemberGiftCard.remain}</Description> 
	
        {buildTransferModal(retailStoreMemberGiftCard,targetComponent)}
      </DescriptionList>
	)

}

const internalQuickFunctions = defaultQuickFunctions

class RetailStoreMemberGiftCardDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'retailStoreMemberGiftCard'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, retailStoreMemberGiftCardConsumeRecordListMetaInfo, retailStoreMemberGiftCardConsumeRecordCount } = this.props.retailStoreMemberGiftCard
    if(!this.props.retailStoreMemberGiftCard.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"零售店会员礼品卡",cardsFor: "retailStoreMemberGiftCard",
    	cardsSource: this.props.retailStoreMemberGiftCard,returnURL,displayName,
  		subItems: [
{name: 'retailStoreMemberGiftCardConsumeRecordList', displayName:'零售商店会员卡消费记录',type:'retailStoreMemberGiftCardConsumeRecord',count:retailStoreMemberGiftCardConsumeRecordCount,addFunction: true, role: 'retailStoreMemberGiftCardConsumeRecord', metaInfo: retailStoreMemberGiftCardConsumeRecordListMetaInfo, renderItem: GlobalComponents.RetailStoreMemberGiftCardConsumeRecordBase.renderItemOfList},
    
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
  retailStoreMemberGiftCard: state._retailStoreMemberGiftCard,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(RetailStoreMemberGiftCardDashboard))


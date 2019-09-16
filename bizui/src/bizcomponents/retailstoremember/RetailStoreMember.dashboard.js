

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
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
import styles from './RetailStoreMember.dashboard.less'
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


const imageList =(retailStoreMember)=>{return [
	 ]}

const internalImageListOf = (retailStoreMember) =>defaultImageListOf(retailStoreMember,imageList)

const optionList =(retailStoreMember)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (retailStoreMember) =>defaultSettingListOf(retailStoreMember, optionList)
const internalLargeTextOf = (retailStoreMember) =>{

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
      <Link to={`/retailStoreMember/${targetComponent.props.retailStoreMember.id}/list/${item.name}/${item.displayName}/`}>
        <span>{item.displayName}</span>
        </Link>
        </Menu.Item>
  )

}
const renderSettingMenu = (cardsData,targetComponent) =>{

  const userContext = null
  return (<Menu>
    	<Menu.Item key="profile">
  			<Link to={`/retailStoreMember/${targetComponent.props.retailStoreMember.id}/permission`}><Icon type="safety-certificate" theme="twoTone" twoToneColor="#52c41a"/><span>{appLocaleName(userContext,"Permission")}</span></Link>
		</Menu.Item>
		<Menu.Divider />
		{cardsData.subSettingItems.map(item=>renderSettingMenuItem(item,cardsData,targetComponent))}
		</Menu>)

}

const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName} {renderSettingDropDown(cardsData,targetComponent)}</div>)

}


const internalSummaryOf = (retailStoreMember,targetComponent) =>{
	
	
	const {RetailStoreMemberService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{retailStoreMember.id}</Description> 
<Description term="名称">{retailStoreMember.name}</Description> 
<Description term="移动电话">{retailStoreMember.mobilePhone}</Description> 
	
        {buildTransferModal(retailStoreMember,targetComponent)}
      </DescriptionList>
	)

}

const internalQuickFunctions = defaultQuickFunctions

class RetailStoreMemberDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'retailStoreMember'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, consumerOrderListMetaInfo, retailStoreMemberCouponListMetaInfo, memberWishlistListMetaInfo, memberRewardPointListMetaInfo, memberRewardPointRedemptionListMetaInfo, retailStoreMemberAddressListMetaInfo, retailStoreMemberGiftCardListMetaInfo, consumerOrderCount, retailStoreMemberCouponCount, memberWishlistCount, memberRewardPointCount, memberRewardPointRedemptionCount, retailStoreMemberAddressCount, retailStoreMemberGiftCardCount } = this.props.retailStoreMember
    if(!this.props.retailStoreMember.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"生超会员",cardsFor: "retailStoreMember",
    	cardsSource: this.props.retailStoreMember,returnURL,displayName,
  		subItems: [
{name: 'consumerOrderList', displayName:'消费者订单',type:'consumerOrder',count:consumerOrderCount,addFunction: true, role: 'consumerOrder', metaInfo: consumerOrderListMetaInfo, renderItem: GlobalComponents.ConsumerOrderBase.renderItemOfList},
{name: 'retailStoreMemberCouponList', displayName:'生超会员优惠券',type:'retailStoreMemberCoupon',count:retailStoreMemberCouponCount,addFunction: true, role: 'retailStoreMemberCoupon', metaInfo: retailStoreMemberCouponListMetaInfo, renderItem: GlobalComponents.RetailStoreMemberCouponBase.renderItemOfList},
{name: 'memberWishlistList', displayName:'会员收藏',type:'memberWishlist',count:memberWishlistCount,addFunction: true, role: 'memberWishlist', metaInfo: memberWishlistListMetaInfo, renderItem: GlobalComponents.MemberWishlistBase.renderItemOfList},
{name: 'memberRewardPointList', displayName:'会员奖励点',type:'memberRewardPoint',count:memberRewardPointCount,addFunction: true, role: 'memberRewardPoint', metaInfo: memberRewardPointListMetaInfo, renderItem: GlobalComponents.MemberRewardPointBase.renderItemOfList},
{name: 'memberRewardPointRedemptionList', displayName:'会员奖励点赎回',type:'memberRewardPointRedemption',count:memberRewardPointRedemptionCount,addFunction: true, role: 'memberRewardPointRedemption', metaInfo: memberRewardPointRedemptionListMetaInfo, renderItem: GlobalComponents.MemberRewardPointRedemptionBase.renderItemOfList},
{name: 'retailStoreMemberAddressList', displayName:'零售店会员地址',type:'retailStoreMemberAddress',count:retailStoreMemberAddressCount,addFunction: true, role: 'retailStoreMemberAddress', metaInfo: retailStoreMemberAddressListMetaInfo, renderItem: GlobalComponents.RetailStoreMemberAddressBase.renderItemOfList},
{name: 'retailStoreMemberGiftCardList', displayName:'零售店会员礼品卡',type:'retailStoreMemberGiftCard',count:retailStoreMemberGiftCardCount,addFunction: true, role: 'retailStoreMemberGiftCard', metaInfo: retailStoreMemberGiftCardListMetaInfo, renderItem: GlobalComponents.RetailStoreMemberGiftCardBase.renderItemOfList},
    
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
  retailStoreMember: state._retailStoreMember,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(RetailStoreMemberDashboard))


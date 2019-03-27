

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
  defaultSubListsOf,
  defaultRenderExtraFooter,renderForTimeLine,renderForNumbers,defaultQuickFunctions
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
const internalSettingListOf = (retailStoreMember) =>defaultSettingListOf(retailStoreMember, optionList)
const internalLargeTextOf = (retailStoreMember) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

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
{name: 'consumerOrderList', displayName:'消费者订单',type:'consumerOrder',count:consumerOrderCount,addFunction: true, role: 'consumerOrder', metaInfo: consumerOrderListMetaInfo},
{name: 'retailStoreMemberCouponList', displayName:'生超会员优惠券',type:'retailStoreMemberCoupon',count:retailStoreMemberCouponCount,addFunction: true, role: 'retailStoreMemberCoupon', metaInfo: retailStoreMemberCouponListMetaInfo},
{name: 'memberWishlistList', displayName:'会员收藏',type:'memberWishlist',count:memberWishlistCount,addFunction: true, role: 'memberWishlist', metaInfo: memberWishlistListMetaInfo},
{name: 'memberRewardPointList', displayName:'会员奖励点',type:'memberRewardPoint',count:memberRewardPointCount,addFunction: true, role: 'memberRewardPoint', metaInfo: memberRewardPointListMetaInfo},
{name: 'memberRewardPointRedemptionList', displayName:'会员奖励点赎回',type:'memberRewardPointRedemption',count:memberRewardPointRedemptionCount,addFunction: true, role: 'memberRewardPointRedemption', metaInfo: memberRewardPointRedemptionListMetaInfo},
{name: 'retailStoreMemberAddressList', displayName:'零售店会员地址',type:'retailStoreMemberAddress',count:retailStoreMemberAddressCount,addFunction: true, role: 'retailStoreMemberAddress', metaInfo: retailStoreMemberAddressListMetaInfo},
{name: 'retailStoreMemberGiftCardList', displayName:'零售店会员礼品卡',type:'retailStoreMemberGiftCard',count:retailStoreMemberGiftCardCount,addFunction: true, role: 'retailStoreMemberGiftCard', metaInfo: retailStoreMemberGiftCardListMetaInfo},
    
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
    const quickFunctions = this.props.quickFunctions || internalQuickFunctions
    return (

      <PageHeaderLayout
        title={renderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
        {quickFunctions(cardsData)} 
        {renderExtraHeader(cardsData.cardsSource)}
        {settingListOf(cardsData.cardsSource)}
        {imageListOf(cardsData.cardsSource)}        
        {largeTextOf(cardsData.cardsSource)}
  
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  retailStoreMember: state._retailStoreMember,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(RetailStoreMemberDashboard))


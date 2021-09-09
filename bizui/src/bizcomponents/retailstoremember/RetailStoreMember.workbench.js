

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
import styles from './RetailStoreMember.workbench.less'
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


  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName} {renderSettingDropDown(cardsData,targetComponent)}</div>)

}


const internalSummaryOf = (cardsData,targetComponent) =>{

	 const quickFunctions = targetComponent.props.quickFunctions || internalQuickFunctions
	const retailStoreMember = cardsData.cardsSource
	const {RetailStoreMemberService} = GlobalComponents
	const userContext = null
	return (
	<div>
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID" style={{wordBreak: 'break-all'}}>{retailStoreMember.id}</Description> 
<Description term="名称" style={{wordBreak: 'break-all'}}>{retailStoreMember.name}</Description> 
<Description term="移动电话" style={{wordBreak: 'break-all'}}>{retailStoreMember.mobilePhone}</Description> 

      
      </DescriptionList>

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

class RetailStoreMemberWorkbench extends Component {

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

    const cardsData = {cardsName:window.trans('retail_store_member'),cardsFor: "retailStoreMember",
    	cardsSource: this.props.retailStoreMember,returnURL,displayName,
  		subItems: [
{name: 'consumerOrderList', displayName: window.mtrans('consumer_order','retail_store_member.consumer_order_list',false) ,viewGroup:'__no_group', type:'consumerOrder',count:consumerOrderCount,addFunction: true, role: 'consumerOrder', metaInfo: consumerOrderListMetaInfo, renderItem: GlobalComponents.ConsumerOrderBase.renderItemOfList},
{name: 'retailStoreMemberCouponList', displayName: window.mtrans('retail_store_member_coupon','retail_store_member.retail_store_member_coupon_list',false) ,viewGroup:'__no_group', type:'retailStoreMemberCoupon',count:retailStoreMemberCouponCount,addFunction: true, role: 'retailStoreMemberCoupon', metaInfo: retailStoreMemberCouponListMetaInfo, renderItem: GlobalComponents.RetailStoreMemberCouponBase.renderItemOfList},
{name: 'memberWishlistList', displayName: window.mtrans('member_wishlist','retail_store_member.member_wishlist_list',false) ,viewGroup:'__no_group', type:'memberWishlist',count:memberWishlistCount,addFunction: true, role: 'memberWishlist', metaInfo: memberWishlistListMetaInfo, renderItem: GlobalComponents.MemberWishlistBase.renderItemOfList},
{name: 'memberRewardPointList', displayName: window.mtrans('member_reward_point','retail_store_member.member_reward_point_list',false) ,viewGroup:'__no_group', type:'memberRewardPoint',count:memberRewardPointCount,addFunction: true, role: 'memberRewardPoint', metaInfo: memberRewardPointListMetaInfo, renderItem: GlobalComponents.MemberRewardPointBase.renderItemOfList},
{name: 'memberRewardPointRedemptionList', displayName: window.mtrans('member_reward_point_redemption','retail_store_member.member_reward_point_redemption_list',false) ,viewGroup:'__no_group', type:'memberRewardPointRedemption',count:memberRewardPointRedemptionCount,addFunction: true, role: 'memberRewardPointRedemption', metaInfo: memberRewardPointRedemptionListMetaInfo, renderItem: GlobalComponents.MemberRewardPointRedemptionBase.renderItemOfList},
{name: 'retailStoreMemberAddressList', displayName: window.mtrans('retail_store_member_address','retail_store_member.retail_store_member_address_list',false) ,viewGroup:'__no_group', type:'retailStoreMemberAddress',count:retailStoreMemberAddressCount,addFunction: true, role: 'retailStoreMemberAddress', metaInfo: retailStoreMemberAddressListMetaInfo, renderItem: GlobalComponents.RetailStoreMemberAddressBase.renderItemOfList},
{name: 'retailStoreMemberGiftCardList', displayName: window.mtrans('retail_store_member_gift_card','retail_store_member.retail_store_member_gift_card_list',false) ,viewGroup:'__no_group', type:'retailStoreMemberGiftCard',count:retailStoreMemberGiftCardCount,addFunction: true, role: 'retailStoreMemberGiftCard', metaInfo: retailStoreMemberGiftCardListMetaInfo, renderItem: GlobalComponents.RetailStoreMemberGiftCardBase.renderItemOfList},

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
        content={summaryOf(cardsData,this)}
        wrapperClassName={styles.advancedForm}
      >

      
       
     <Col span={18} style={{marginRight:"20px", backgroundColor: "white"}}>
      {quickFunctions(cardsData)}

      {largeTextOf(cardsData.cardsSource)}
      {renderSubjectList(cardsData)} 
      {renderExtraFooter(cardsData.cardsSource)}
	   </Col>
      <Col span={5}>

			{imageListOf(cardsData.cardsSource)}
			{settingListOf(cardsData.cardsSource)}
		</Col>
		 
      </PageHeaderLayout>

    )
  }
}

export default connect(state => ({
  retailStoreMember: state._retailStoreMember,
  returnURL: state.breadcrumb.returnURL,

}))(Form.create()(RetailStoreMemberWorkbench))


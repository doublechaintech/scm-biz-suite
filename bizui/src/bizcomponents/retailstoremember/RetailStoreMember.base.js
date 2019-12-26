import React from 'react'
<<<<<<< HEAD
import { Icon,Divider } from 'antd'
=======
import { Icon,Divider, Avata, Card, Col} from 'antd'
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
<<<<<<< HEAD
=======

>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const {
	defaultRenderReferenceCell,
	defaultRenderBooleanCell,
	defaultRenderMoneyCell,
	defaultRenderDateTimeCell,
	defaultRenderImageCell,
<<<<<<< HEAD
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
=======
	defaultRenderAvatarCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
	defaultSearchLocalData,
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
<<<<<<< HEAD
=======
const renderAvatarCell=defaultRenderAvatarCell
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell


<<<<<<< HEAD
const menuData = {menuName:"生超会员", menuFor: "retailStoreMember",
  		subItems: [
  {name: 'consumerOrderList', displayName:'消费者订单', icon:'first-order',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'retailStoreMemberCouponList', displayName:'生超会员优惠券', icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'memberWishlistList', displayName:'会员收藏', icon:'ember',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'memberRewardPointList', displayName:'会员奖励点', icon:'ember',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'memberRewardPointRedemptionList', displayName:'会员奖励点赎回', icon:'ember',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'retailStoreMemberAddressList', displayName:'零售店会员地址', icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'retailStoreMemberGiftCardList', displayName:'零售店会员礼品卡', icon:'gift',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('retail_store_member'), menuFor: "retailStoreMember",
  		subItems: [
  {name: 'consumerOrderList', displayName: window.mtrans('consumer_order','retail_store_member.consumer_order_list',false), type:'consumerOrder',icon:'first-order',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'retailStoreMemberCouponList', displayName: window.mtrans('retail_store_member_coupon','retail_store_member.retail_store_member_coupon_list',false), type:'retailStoreMemberCoupon',icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'memberWishlistList', displayName: window.mtrans('member_wishlist','retail_store_member.member_wishlist_list',false), type:'memberWishlist',icon:'ember',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'memberRewardPointList', displayName: window.mtrans('member_reward_point','retail_store_member.member_reward_point_list',false), type:'memberRewardPoint',icon:'ember',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'memberRewardPointRedemptionList', displayName: window.mtrans('member_reward_point_redemption','retail_store_member.member_reward_point_redemption_list',false), type:'memberRewardPointRedemption',icon:'ember',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'retailStoreMemberAddressList', displayName: window.mtrans('retail_store_member_address','retail_store_member.retail_store_member_address_list',false), type:'retailStoreMemberAddress',icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'retailStoreMemberGiftCardList', displayName: window.mtrans('retail_store_member_gift_card','retail_store_member.retail_store_member_gift_card_list',false), type:'retailStoreMemberGiftCard',icon:'gift',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}

<<<<<<< HEAD

const settingMenuData = {menuName:"生超会员", menuFor: "retailStoreMember",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  name: '名称',
  mobilePhone: '移动电话',
  owner: '业主',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'retailStoreMember') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.mobilePhone, debugtype: 'string_china_mobile_phone', dataIndex: 'mobilePhone', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.owner, dataIndex: 'owner', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(retailStoreMember,targetComponent)=>{

  const userContext = null
  return (
    <div key={retailStoreMember.id}>
	
      <DescriptionList  key={retailStoreMember.id} size="small" col="4">
        <Description term="序号">{retailStoreMember.id}</Description> 
        <Description term="名称">{retailStoreMember.name}</Description> 
        <Description term="移动电话">{retailStoreMember.mobilePhone}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, mobilePhone, ownerId} = formValuesToPack
	const owner = {id: ownerId, version: 2^31}
	const data = {name, mobilePhone, owner}
	return data
}
=======

const settingMenuData = {menuName: window.trans('retail_store_member'), menuFor: "retailStoreMember",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('retail_store_member.id'),
  name: window.trans('retail_store_member.name'),
  mobilePhone: window.trans('retail_store_member.mobile_phone'),
  owner: window.trans('retail_store_member.owner'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'retailStoreMember') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.mobilePhone, debugtype: 'string_china_mobile_phone', dataIndex: 'mobilePhone', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.owner, dataIndex: 'owner', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(retailStoreMember,targetComponent)=>{

  const userContext = null
  return (
    <div key={retailStoreMember.id}>
	
      <DescriptionList  key={retailStoreMember.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{retailStoreMember.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{retailStoreMember.name}</Description> 
        <Description term={fieldLabels.mobilePhone} style={{wordBreak: 'break-all'}}>{retailStoreMember.mobilePhone}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, mobilePhone, ownerId} = formValuesToPack
	const owner = {id: ownerId, version: 2^31}
	const data = {name, mobilePhone, owner}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, mobilePhone, owner} = objectToUnpack
	const ownerId = owner ? owner.id : null
	const data = {name, mobilePhone, ownerId}
	return data
}
<<<<<<< HEAD

const RetailStoreMemberBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
=======
const stepOf=(targetComponent, title, content, position, index)=>{
	return {
		title,
		content,
		position,
		packFunction: packFormValuesToObject,
		unpackFunction: unpackObjectToFormValues,
		index,
      }
}
const RetailStoreMemberBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default RetailStoreMemberBase




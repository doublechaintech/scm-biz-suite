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
const menuData = {menuName:"生超会员优惠券", menuFor: "retailStoreMemberCoupon",
=======

const menuData = {menuName: window.trans('retail_store_member_coupon'), menuFor: "retailStoreMemberCoupon",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

<<<<<<< HEAD

const settingMenuData = {menuName:"生超会员优惠券", menuFor: "retailStoreMemberCoupon",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  name: '名称',
  owner: '业主',
  number: '数',
  lastUpdateTime: '最后更新时间',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'retailStoreMemberCoupon') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.owner, dataIndex: 'owner', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.number, debugtype: 'string', dataIndex: 'number', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(retailStoreMemberCoupon,targetComponent)=>{

  const userContext = null
  return (
    <div key={retailStoreMemberCoupon.id}>
	
      <DescriptionList  key={retailStoreMemberCoupon.id} size="small" col="4">
        <Description term="序号">{retailStoreMemberCoupon.id}</Description> 
        <Description term="名称">{retailStoreMemberCoupon.name}</Description> 
        <Description term="业主"><div>{retailStoreMemberCoupon.owner==null?appLocaleName(userContext,"NotAssigned"):`${retailStoreMemberCoupon.owner.displayName}(${retailStoreMemberCoupon.owner.id})`}
        </div></Description>
        <Description term="数">{retailStoreMemberCoupon.number}</Description> 
        <Description term="最后更新时间"><div>{ moment(retailStoreMemberCoupon.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, number, ownerId} = formValuesToPack
	const owner = {id: ownerId, version: 2^31}
	const data = {name, number, owner}
	return data
}
=======

const settingMenuData = {menuName: window.trans('retail_store_member_coupon'), menuFor: "retailStoreMemberCoupon",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('retail_store_member_coupon.id'),
  name: window.trans('retail_store_member_coupon.name'),
  owner: window.trans('retail_store_member_coupon.owner'),
  number: window.trans('retail_store_member_coupon.number'),
  lastUpdateTime: window.trans('retail_store_member_coupon.last_update_time'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'retailStoreMemberCoupon') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.owner, dataIndex: 'owner', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.number, debugtype: 'string', dataIndex: 'number', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(retailStoreMemberCoupon,targetComponent)=>{

  const userContext = null
  return (
    <div key={retailStoreMemberCoupon.id}>
	
      <DescriptionList  key={retailStoreMemberCoupon.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{retailStoreMemberCoupon.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{retailStoreMemberCoupon.name}</Description> 
        <Description term={fieldLabels.owner}><div>{retailStoreMemberCoupon.owner==null?appLocaleName(userContext,"NotAssigned"):`${retailStoreMemberCoupon.owner.displayName}(${retailStoreMemberCoupon.owner.id})`}
        </div></Description>
        <Description term={fieldLabels.number} style={{wordBreak: 'break-all'}}>{retailStoreMemberCoupon.number}</Description> 
        <Description term={fieldLabels.lastUpdateTime}><div>{ moment(retailStoreMemberCoupon.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, number, ownerId} = formValuesToPack
	const owner = {id: ownerId, version: 2^31}
	const data = {name, number, owner}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, number, owner} = objectToUnpack
	const ownerId = owner ? owner.id : null
	const data = {name, number, ownerId}
	return data
}
<<<<<<< HEAD

const RetailStoreMemberCouponBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const RetailStoreMemberCouponBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default RetailStoreMemberCouponBase




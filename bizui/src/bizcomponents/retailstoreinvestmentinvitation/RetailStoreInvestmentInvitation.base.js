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
const menuData = {menuName:"生超招商", menuFor: "retailStoreInvestmentInvitation",
  		subItems: [
  {name: 'retailStoreList', displayName:'双链小超', icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('retail_store_investment_invitation'), menuFor: "retailStoreInvestmentInvitation",
  		subItems: [
  {name: 'retailStoreList', displayName: window.mtrans('retail_store','retail_store_investment_invitation.retail_store_list',false), type:'retailStore',icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}


<<<<<<< HEAD
const settingMenuData = {menuName:"生超招商", menuFor: "retailStoreInvestmentInvitation",
=======
const settingMenuData = {menuName: window.trans('retail_store_investment_invitation'), menuFor: "retailStoreInvestmentInvitation",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

const fieldLabels = {
<<<<<<< HEAD
  id: '序号',
  comment: '评论',
=======
  id: window.trans('retail_store_investment_invitation.id'),
  comment: window.trans('retail_store_investment_invitation.comment'),
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'retailStoreInvestmentInvitation') , sorter: true },
  { title: fieldLabels.comment, debugtype: 'string', dataIndex: 'comment', width: '10',render: (text, record)=>renderTextCell(text,record)},

]
<<<<<<< HEAD
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(retailStoreInvestmentInvitation,targetComponent)=>{

  const userContext = null
  return (
    <div key={retailStoreInvestmentInvitation.id}>
	
      <DescriptionList  key={retailStoreInvestmentInvitation.id} size="small" col="4">
        <Description term="序号">{retailStoreInvestmentInvitation.id}</Description> 
        <Description term="评论">{retailStoreInvestmentInvitation.comment}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {comment} = formValuesToPack

	const data = {comment}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {comment} = objectToUnpack
=======


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(retailStoreInvestmentInvitation,targetComponent)=>{

  const userContext = null
  return (
    <div key={retailStoreInvestmentInvitation.id}>
	
      <DescriptionList  key={retailStoreInvestmentInvitation.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{retailStoreInvestmentInvitation.id}</Description> 
        <Description term={fieldLabels.comment} style={{wordBreak: 'break-all'}}>{retailStoreInvestmentInvitation.comment}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {comment} = formValuesToPack
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

	const data = {comment}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {comment} = objectToUnpack

<<<<<<< HEAD
const RetailStoreInvestmentInvitationBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
=======
	const data = {comment}
	return data
}
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
const RetailStoreInvestmentInvitationBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default RetailStoreInvestmentInvitationBase




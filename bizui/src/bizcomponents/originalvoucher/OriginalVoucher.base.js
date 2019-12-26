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
const menuData = {menuName:"原始凭证", menuFor: "originalVoucher",
=======

const menuData = {menuName: window.trans('original_voucher'), menuFor: "originalVoucher",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

<<<<<<< HEAD
=======

const settingMenuData = {menuName: window.trans('original_voucher'), menuFor: "originalVoucher",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('original_voucher.id'),
  title: window.trans('original_voucher.title'),
  madeBy: window.trans('original_voucher.made_by'),
  receivedBy: window.trans('original_voucher.received_by'),
  voucherType: window.trans('original_voucher.voucher_type'),
  voucherImage: window.trans('original_voucher.voucher_image'),
  belongsTo: window.trans('original_voucher.belongs_to'),
  creation: window.trans('original_voucher.creation'),
  confirmation: window.trans('original_voucher.confirmation'),
  auditing: window.trans('original_voucher.auditing'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'originalVoucher') , sorter: true },
  { title: fieldLabels.title, debugtype: 'string', dataIndex: 'title', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.madeBy, debugtype: 'string', dataIndex: 'madeBy', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.receivedBy, debugtype: 'string', dataIndex: 'receivedBy', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.voucherType, debugtype: 'string', dataIndex: 'voucherType', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.voucherImage, dataIndex: 'voucherImage', render: (text, record) => renderImageCell(text,record,'original_voucher.voucher_image') },
  { title: fieldLabels.belongsTo, dataIndex: 'belongsTo', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.creation, dataIndex: 'creation', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.confirmation, dataIndex: 'confirmation', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.auditing, dataIndex: 'auditing', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(originalVoucher,targetComponent)=>{

  const userContext = null
  return (
    <div key={originalVoucher.id}>
	
      <DescriptionList  key={originalVoucher.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{originalVoucher.id}</Description> 
        <Description term={fieldLabels.title} style={{wordBreak: 'break-all'}}>{originalVoucher.title}</Description> 
        <Description term={fieldLabels.madeBy} style={{wordBreak: 'break-all'}}>{originalVoucher.madeBy}</Description> 
        <Description term={fieldLabels.receivedBy} style={{wordBreak: 'break-all'}}>{originalVoucher.receivedBy}</Description> 
        <Description term={fieldLabels.voucherType} style={{wordBreak: 'break-all'}}>{originalVoucher.voucherType}</Description> 
        <Description term={fieldLabels.belongsTo}><div>{originalVoucher.belongsTo==null?appLocaleName(userContext,"NotAssigned"):`${originalVoucher.belongsTo.displayName}(${originalVoucher.belongsTo.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"原始凭证", menuFor: "originalVoucher",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

const fieldLabels = {
  id: '序号',
  title: '头衔',
  madeBy: '由',
  receivedBy: '受',
  voucherType: '凭证类型',
  voucherImage: '凭证图像',
  belongsTo: '属于',
  creation: '创建',
  confirmation: '确认',
  auditing: '审计',
  currentStatus: '当前状态',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'originalVoucher') , sorter: true },
  { title: fieldLabels.title, debugtype: 'string', dataIndex: 'title', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.madeBy, debugtype: 'string', dataIndex: 'madeBy', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.receivedBy, debugtype: 'string', dataIndex: 'receivedBy', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.voucherType, debugtype: 'string', dataIndex: 'voucherType', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.voucherImage, dataIndex: 'voucherImage', render: (text, record) => renderImageCell(text,record,'凭证图像') },
  { title: fieldLabels.belongsTo, dataIndex: 'belongsTo', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.creation, dataIndex: 'creation', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.confirmation, dataIndex: 'confirmation', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.auditing, dataIndex: 'auditing', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.currentStatus, debugtype: 'string', dataIndex: 'currentStatus', width: '13',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(originalVoucher,targetComponent)=>{

  const userContext = null
  return (
    <div key={originalVoucher.id}>
	
      <DescriptionList  key={originalVoucher.id} size="small" col="4">
        <Description term="序号">{originalVoucher.id}</Description> 
        <Description term="头衔">{originalVoucher.title}</Description> 
        <Description term="由">{originalVoucher.madeBy}</Description> 
        <Description term="受">{originalVoucher.receivedBy}</Description> 
        <Description term="凭证类型">{originalVoucher.voucherType}</Description> 
        <Description term="属于"><div>{originalVoucher.belongsTo==null?appLocaleName(userContext,"NotAssigned"):`${originalVoucher.belongsTo.displayName}(${originalVoucher.belongsTo.id})`}
        </div></Description>
        <Description term="当前状态">{originalVoucher.currentStatus}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {title, madeBy, receivedBy, voucherType, belongsToId} = formValuesToPack
	const belongsTo = {id: belongsToId, version: 2^31}
	const data = {title, madeBy, receivedBy, voucherType, belongsTo}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {title, madeBy, receivedBy, voucherType, belongsTo} = objectToUnpack
	const belongsToId = belongsTo ? belongsTo.id : null
	const data = {title, madeBy, receivedBy, voucherType, belongsToId}
	return data
}

const OriginalVoucherBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {title, madeBy, receivedBy, voucherType, belongsToId, creationId, confirmationId, auditingId} = formValuesToPack
	const belongsTo = {id: belongsToId, version: 2^31}
	const creation = {id: creationId, version: 2^31}
	const confirmation = {id: confirmationId, version: 2^31}
	const auditing = {id: auditingId, version: 2^31}
	const data = {title, madeBy, receivedBy, voucherType, belongsTo, creation, confirmation, auditing}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {title, madeBy, receivedBy, voucherType, belongsTo, creation, confirmation, auditing} = objectToUnpack
	const belongsToId = belongsTo ? belongsTo.id : null
	const creationId = creation ? creation.id : null
	const confirmationId = confirmation ? confirmation.id : null
	const auditingId = auditing ? auditing.id : null
	const data = {title, madeBy, receivedBy, voucherType, belongsToId, creationId, confirmationId, auditingId}
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
const OriginalVoucherBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default OriginalVoucherBase




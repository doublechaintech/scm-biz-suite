import React from 'react'
import { Icon,Divider, Avata, Card, Col} from 'antd'

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList

const {
	defaultRenderReferenceCell,
	defaultRenderBooleanCell,
	defaultRenderMoneyCell,
	defaultRenderDateTimeCell,
	defaultRenderImageCell,
	defaultRenderAvatarCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
	defaultSearchLocalData,
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
const renderAvatarCell=defaultRenderAvatarCell
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell



const menuData = {menuName: window.trans('original_voucher'), menuFor: "originalVoucher",
  		subItems: [
  
  		],
}


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

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'originalVoucher') , sorter: true },
  { title: fieldLabels.title, debugtype: 'string', dataIndex: 'title', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.madeBy, debugtype: 'string', dataIndex: 'madeBy', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.receivedBy, debugtype: 'string', dataIndex: 'receivedBy', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.voucherType, debugtype: 'string', dataIndex: 'voucherType', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.voucherImage, dataIndex: 'voucherImage', render: (text, record) => renderImageCell(text,record,'original_voucher.voucher_image') },
  { title: fieldLabels.belongsTo, dataIndex: 'belongsTo', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(originalVoucher, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 2
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
export default OriginalVoucherBase




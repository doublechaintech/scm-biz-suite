import React from 'react'
import { Icon,Divider, Avatar, Card, Col, Tag} from 'antd'

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
import styles from './OriginalVoucher.base.less'
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
const colorList = ['#f56a00', '#7265e6', '#ffbf00', '#00a2ae'];
let counter = 0;
const genColor=()=>{
	counter++;
	return colorList[counter%colorList.length];
}
const followColor=()=>{
	return 'green';
	// return colorList[counter%colorList.length];
}
const leftChars=(value, left)=>{
	const chars = left || 4
	if(!value){
		return "N/A"
	}
	return value.substring(0,chars);
}
const renderItemOfList=(originalVoucher, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={originalVoucher.id} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(originalVoucher.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={originalVoucher.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{originalVoucher.id}</Description> 
        <Description term={fieldLabels.title} style={{wordBreak: 'break-all'}}>{originalVoucher.title}</Description> 
        <Description term={fieldLabels.madeBy} style={{wordBreak: 'break-all'}}>{originalVoucher.madeBy}</Description> 
        <Description term={fieldLabels.receivedBy} style={{wordBreak: 'break-all'}}>{originalVoucher.receivedBy}</Description> 
        <Description term={fieldLabels.voucherType} style={{wordBreak: 'break-all'}}>{originalVoucher.voucherType}</Description> 
        <Description term={fieldLabels.belongsTo}><Tag color='blue' title={`${originalVoucher.belongsTo.id}-${originalVoucher.belongsTo.displayName}`}>{originalVoucher.belongsTo==null?appLocaleName(userContext,"NotAssigned"):`${leftChars(originalVoucher.belongsTo.displayName,15)}`}
        </Tag></Description>
	
        
      </DescriptionList>
     </Col>
    </Card>
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
const OriginalVoucherBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default OriginalVoucherBase


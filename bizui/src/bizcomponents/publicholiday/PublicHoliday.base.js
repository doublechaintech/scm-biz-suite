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



const menuData = {menuName: window.trans('public_holiday'), menuFor: "publicHoliday",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('public_holiday'), menuFor: "publicHoliday",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('public_holiday.id'),
  code: window.trans('public_holiday.code'),
  company: window.trans('public_holiday.company'),
  name: window.trans('public_holiday.name'),
  description: window.trans('public_holiday.description'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'publicHoliday') , sorter: true },
  { title: fieldLabels.code, debugtype: 'string', dataIndex: 'code', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.company, dataIndex: 'company', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '14',render: (text, record)=>renderTextCell(text,record)},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(publicHoliday,targetComponent)=>{

  const userContext = null
  return (
    <div key={publicHoliday.id}>
	
      <DescriptionList  key={publicHoliday.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{publicHoliday.id}</Description> 
        <Description term={fieldLabels.code} style={{wordBreak: 'break-all'}}>{publicHoliday.code}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{publicHoliday.name}</Description> 
        <Description term={fieldLabels.description} style={{wordBreak: 'break-all'}}>{publicHoliday.description}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {code, name, description, companyId} = formValuesToPack
	const company = {id: companyId, version: 2^31}
	const data = {code, name, description, company}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {code, name, description, company} = objectToUnpack
	const companyId = company ? company.id : null
	const data = {code, name, description, companyId}
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
const PublicHolidayBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default PublicHolidayBase




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



const menuData = {menuName: window.trans('candidate_element'), menuFor: "candidateElement",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('candidate_element'), menuFor: "candidateElement",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('candidate_element.id'),
  name: window.trans('candidate_element.name'),
  type: window.trans('candidate_element.type'),
  image: window.trans('candidate_element.image'),
  container: window.trans('candidate_element.container'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'candidateElement') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '12',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.type, debugtype: 'string', dataIndex: 'type', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.image, dataIndex: 'image', render: (text, record) => renderImageCell(text,record,'candidate_element.image') },
  { title: fieldLabels.container, dataIndex: 'container', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(candidateElement, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 2
  const userContext = null
  return (
    <div key={candidateElement.id}>
	
      <DescriptionList  key={candidateElement.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{candidateElement.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{candidateElement.name}</Description> 
        <Description term={fieldLabels.type} style={{wordBreak: 'break-all'}}>{candidateElement.type}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, type, containerId} = formValuesToPack
	const container = {id: containerId, version: 2^31}
	const data = {name, type, container}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, type, container} = objectToUnpack
	const containerId = container ? container.id : null
	const data = {name, type, containerId}
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
const CandidateElementBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default CandidateElementBase











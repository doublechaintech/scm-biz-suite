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
const menuData = {menuName:"候选人元素", menuFor: "candidateElement",
=======

const menuData = {menuName: window.trans('candidate_element'), menuFor: "candidateElement",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}


<<<<<<< HEAD
const settingMenuData = {menuName:"候选人元素", menuFor: "candidateElement",
=======
const settingMenuData = {menuName: window.trans('candidate_element'), menuFor: "candidateElement",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

const fieldLabels = {
<<<<<<< HEAD
  id: 'ID',
  name: '名称',
  type: '类型',
  image: '图片',
  container: '容器',
=======
  id: window.trans('candidate_element.id'),
  name: window.trans('candidate_element.name'),
  type: window.trans('candidate_element.type'),
  image: window.trans('candidate_element.image'),
  container: window.trans('candidate_element.container'),
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'candidateElement') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '12',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.type, debugtype: 'string', dataIndex: 'type', width: '8',render: (text, record)=>renderTextCell(text,record)},
<<<<<<< HEAD
  { title: fieldLabels.image, dataIndex: 'image', render: (text, record) => renderImageCell(text,record,'图片') },
  { title: fieldLabels.container, dataIndex: 'container', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
=======
  { title: fieldLabels.image, dataIndex: 'image', render: (text, record) => renderImageCell(text,record,'candidate_element.image') },
  { title: fieldLabels.container, dataIndex: 'container', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const renderItemOfList=(candidateElement,targetComponent)=>{

  const userContext = null
  return (
    <div key={candidateElement.id}>
	
<<<<<<< HEAD
      <DescriptionList  key={candidateElement.id} size="small" col="4">
        <Description term="ID">{candidateElement.id}</Description> 
        <Description term="名称">{candidateElement.name}</Description> 
        <Description term="类型">{candidateElement.type}</Description> 
=======
      <DescriptionList  key={candidateElement.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{candidateElement.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{candidateElement.name}</Description> 
        <Description term={fieldLabels.type} style={{wordBreak: 'break-all'}}>{candidateElement.type}</Description> 
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
	
        
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
<<<<<<< HEAD

const CandidateElementBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const CandidateElementBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default CandidateElementBase











import React from 'react'
import { Icon,Divider } from 'antd'

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
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell


const menuData = {menuName:"候选人元素", menuFor: "candidateElement",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName:"候选人元素", menuFor: "candidateElement",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'ID',
  name: '名称',
  type: '类型',
  image: '图片',
  container: '容器',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'candidateElement') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '12',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.type, debugtype: 'string', dataIndex: 'type', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.image, dataIndex: 'image', render: (text, record) => renderImageCell(text,record,'图片') },
  { title: fieldLabels.container, dataIndex: 'container', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(candidateElement,targetComponent)=>{

  const userContext = null
  return (
    <div key={candidateElement.id}>
	
      <DescriptionList  key={candidateElement.id} size="small" col="4">
        <Description term="ID">{candidateElement.id}</Description> 
        <Description term="名称">{candidateElement.name}</Description> 
        <Description term="类型">{candidateElement.type}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const CandidateElementBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default CandidateElementBase











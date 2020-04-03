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
import styles from './TreeNode.base.less'
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



const menuData = {menuName: window.trans('tree_node'), menuFor: "treeNode",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('tree_node'), menuFor: "treeNode",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('tree_node.id'),
  nodeId: window.trans('tree_node.node_id'),
  nodeType: window.trans('tree_node.node_type'),
  leftValue: window.trans('tree_node.left_value'),
  rightValue: window.trans('tree_node.right_value'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'treeNode') , sorter: true },
  { title: fieldLabels.nodeId, debugtype: 'string', dataIndex: 'nodeId', width: '14',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.nodeType, debugtype: 'string', dataIndex: 'nodeType', width: '12',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.leftValue, dataIndex: 'leftValue', className:'money', render: (text, record) => renderTextCell(text, record), sorter: true  },
  { title: fieldLabels.rightValue, dataIndex: 'rightValue', className:'money', render: (text, record) => renderTextCell(text, record), sorter: true  },

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

const renderReferenceItem=(value, targetComponent)=>{
	const userContext = null
	if(!value){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.id){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.displayName){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	
	return <Tag color='blue' title={`${value.displayName}()`}>{leftChars(value.displayName)}</Tag>
	
	
	
	
}
const renderItemOfList=(treeNode, targetComponent, columCount)=>{
  
  if(!treeNode){
  	return null
  }
  if(!treeNode.id){
  	return null
  }
  
  
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={`treeNode-${treeNode.id}`} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(treeNode.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={treeNode.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{treeNode.id}</Description> 
        <Description term={fieldLabels.nodeId} style={{wordBreak: 'break-all'}}>{treeNode.nodeId}</Description> 
        <Description term={fieldLabels.nodeType} style={{wordBreak: 'break-all'}}>{treeNode.nodeType}</Description> 
        <Description term={fieldLabels.leftValue}><div style={{"color":"red"}}>{treeNode.leftValue}</div></Description> 
        <Description term={fieldLabels.rightValue}><div style={{"color":"red"}}>{treeNode.rightValue}</div></Description> 
	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {nodeId, nodeType, leftValue, rightValue} = formValuesToPack

	const data = {nodeId, nodeType, leftValue, rightValue}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {nodeId, nodeType, leftValue, rightValue} = objectToUnpack

	const data = {nodeId, nodeType, leftValue, rightValue}
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
const TreeNodeBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default TreeNodeBase


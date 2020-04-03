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
import styles from './QuickLink.base.less'
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



const menuData = {menuName: window.trans('quick_link'), menuFor: "quickLink",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('quick_link'), menuFor: "quickLink",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('quick_link.id'),
  name: window.trans('quick_link.name'),
  icon: window.trans('quick_link.icon'),
  imagePath: window.trans('quick_link.image_path'),
  linkTarget: window.trans('quick_link.link_target'),
  createTime: window.trans('quick_link.create_time'),
  app: window.trans('quick_link.app'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'quickLink') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.icon, debugtype: 'string', dataIndex: 'icon', width: '12',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.imagePath, dataIndex: 'imagePath', render: (text, record) => renderImageCell(text,record,'quick_link.image_path') },
  { title: fieldLabels.linkTarget, debugtype: 'string', dataIndex: 'linkTarget', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.createTime, dataIndex: 'createTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},
  { title: fieldLabels.app, dataIndex: 'app', render: (text, record) => renderReferenceCell(text, record), sorter:true},

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
const renderItemOfList=(quickLink, targetComponent, columCount)=>{
  
  if(!quickLink){
  	return null
  }
  if(!quickLink.id){
  	return null
  }
  
  
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={`quickLink-${quickLink.id}`} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(quickLink.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={quickLink.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{quickLink.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{quickLink.name}</Description> 
        <Description term={fieldLabels.icon} style={{wordBreak: 'break-all'}}>{quickLink.icon}</Description> 
        <Description term={fieldLabels.linkTarget} style={{wordBreak: 'break-all'}}>{quickLink.linkTarget}</Description> 
        <Description term={fieldLabels.createTime}><div>{ moment(quickLink.createTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
        <Description term={fieldLabels.app}>{renderReferenceItem(quickLink.app)}</Description>

	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, icon, linkTarget, appId} = formValuesToPack
	const app = {id: appId, version: 2^31}
	const data = {name, icon, linkTarget, app}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, icon, linkTarget, app} = objectToUnpack
	const appId = app ? app.id : null
	const data = {name, icon, linkTarget, appId}
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
const QuickLinkBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default QuickLinkBase


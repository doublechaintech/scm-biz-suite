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
import styles from './WechatWorkappIdentify.base.less'
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



const menuData = {menuName: window.trans('wechat_workapp_identify'), menuFor: "wechatWorkappIdentify",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('wechat_workapp_identify'), menuFor: "wechatWorkappIdentify",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('wechat_workapp_identify.id'),
  corpId: window.trans('wechat_workapp_identify.corp_id'),
  userId: window.trans('wechat_workapp_identify.user_id'),
  secUser: window.trans('wechat_workapp_identify.sec_user'),
  createTime: window.trans('wechat_workapp_identify.create_time'),
  lastLoginTime: window.trans('wechat_workapp_identify.last_login_time'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'wechatWorkappIdentify') , sorter: true },
  { title: fieldLabels.corpId, debugtype: 'string', dataIndex: 'corpId', width: '18',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.userId, debugtype: 'string', dataIndex: 'userId', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.secUser, dataIndex: 'secUser', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.createTime, dataIndex: 'createTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},
  { title: fieldLabels.lastLoginTime, dataIndex: 'lastLoginTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

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
const renderItemOfList=(wechatWorkappIdentify, targetComponent, columCount)=>{
  
  if(!wechatWorkappIdentify){
  	return null
  }
  if(!wechatWorkappIdentify.id){
  	return null
  }
  
  
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={`wechatWorkappIdentify-${wechatWorkappIdentify.id}`} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(wechatWorkappIdentify.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={wechatWorkappIdentify.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{wechatWorkappIdentify.id}</Description> 
        <Description term={fieldLabels.corpId} style={{wordBreak: 'break-all'}}>{wechatWorkappIdentify.corpId}</Description> 
        <Description term={fieldLabels.userId} style={{wordBreak: 'break-all'}}>{wechatWorkappIdentify.userId}</Description> 
        <Description term={fieldLabels.secUser}>{renderReferenceItem(wechatWorkappIdentify.secUser)}</Description>

        <Description term={fieldLabels.createTime}><div>{ moment(wechatWorkappIdentify.createTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
        <Description term={fieldLabels.lastLoginTime}><div>{ moment(wechatWorkappIdentify.lastLoginTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {corpId, userId, lastLoginTime, secUserId} = formValuesToPack
	const secUser = {id: secUserId, version: 2^31}
	const data = {corpId, userId, lastLoginTime:moment(lastLoginTime).valueOf(), secUser}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {corpId, userId, lastLoginTime, secUser} = objectToUnpack
	const secUserId = secUser ? secUser.id : null
	const data = {corpId, userId, lastLoginTime:moment(lastLoginTime), secUserId}
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
const WechatWorkappIdentifyBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default WechatWorkappIdentifyBase


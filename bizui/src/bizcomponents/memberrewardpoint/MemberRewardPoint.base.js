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
import styles from './MemberRewardPoint.base.less'
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



const menuData = {menuName: window.trans('member_reward_point'), menuFor: "memberRewardPoint",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('member_reward_point'), menuFor: "memberRewardPoint",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('member_reward_point.id'),
  name: window.trans('member_reward_point.name'),
  point: window.trans('member_reward_point.point'),
  owner: window.trans('member_reward_point.owner'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'memberRewardPoint') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.point, dataIndex: 'point', className:'money', render: (text, record) => renderTextCell(text, record), sorter: true  },
  { title: fieldLabels.owner, dataIndex: 'owner', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)
<<<<<<< HEAD
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
const renderItemOfList=(memberRewardPoint, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 4
=======

const renderItemOfList=(memberRewardPoint, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 2
>>>>>>> b1266426b024c6919f91c6b5be4635d10d614fe9
  const userContext = null
  return (
    <Card key={memberRewardPoint.id} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(memberRewardPoint.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={memberRewardPoint.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{memberRewardPoint.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{memberRewardPoint.name}</Description> 
        <Description term={fieldLabels.point}><div style={{"color":"red"}}>{memberRewardPoint.point}</div></Description> 
        <Description term={fieldLabels.owner}><Tag color='blue' title={`${memberRewardPoint.owner.id}-${memberRewardPoint.owner.displayName}`}>{memberRewardPoint.owner==null?appLocaleName(userContext,"NotAssigned"):`${leftChars(memberRewardPoint.owner.displayName,15)}`}
        </Tag></Description>
	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, point, ownerId} = formValuesToPack
	const owner = {id: ownerId, version: 2^31}
	const data = {name, point, owner}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, point, owner} = objectToUnpack
	const ownerId = owner ? owner.id : null
	const data = {name, point, ownerId}
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
const MemberRewardPointBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default MemberRewardPointBase


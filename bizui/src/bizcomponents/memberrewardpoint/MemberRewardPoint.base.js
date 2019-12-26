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
const menuData = {menuName:"会员奖励点", menuFor: "memberRewardPoint",
=======

const menuData = {menuName: window.trans('member_reward_point'), menuFor: "memberRewardPoint",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

<<<<<<< HEAD

const settingMenuData = {menuName:"会员奖励点", menuFor: "memberRewardPoint",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  name: '名称',
  point: '点',
  owner: '业主',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'memberRewardPoint') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.point, debugtype: 'int', dataIndex: 'point', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.owner, dataIndex: 'owner', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(memberRewardPoint,targetComponent)=>{

  const userContext = null
  return (
    <div key={memberRewardPoint.id}>
	
      <DescriptionList  key={memberRewardPoint.id} size="small" col="4">
        <Description term="序号">{memberRewardPoint.id}</Description> 
        <Description term="名称">{memberRewardPoint.name}</Description> 
        <Description term="点"><div style={{"color":"red"}}>{memberRewardPoint.point}</div></Description> 
        <Description term="业主"><div>{memberRewardPoint.owner==null?appLocaleName(userContext,"NotAssigned"):`${memberRewardPoint.owner.displayName}(${memberRewardPoint.owner.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, point, ownerId} = formValuesToPack
	const owner = {id: ownerId, version: 2^31}
	const data = {name, point, owner}
	return data
}
=======

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
  { title: fieldLabels.point, debugtype: 'int', dataIndex: 'point', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.owner, dataIndex: 'owner', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(memberRewardPoint,targetComponent)=>{

  const userContext = null
  return (
    <div key={memberRewardPoint.id}>
	
      <DescriptionList  key={memberRewardPoint.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{memberRewardPoint.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{memberRewardPoint.name}</Description> 
        <Description term={fieldLabels.point}><div style={{"color":"red"}}>{memberRewardPoint.point}</div></Description> 
        <Description term={fieldLabels.owner}><div>{memberRewardPoint.owner==null?appLocaleName(userContext,"NotAssigned"):`${memberRewardPoint.owner.displayName}(${memberRewardPoint.owner.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, point, ownerId} = formValuesToPack
	const owner = {id: ownerId, version: 2^31}
	const data = {name, point, owner}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, point, owner} = objectToUnpack
	const ownerId = owner ? owner.id : null
	const data = {name, point, ownerId}
	return data
}
<<<<<<< HEAD

const MemberRewardPointBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const MemberRewardPointBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default MemberRewardPointBase




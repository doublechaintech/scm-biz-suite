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



const menuData = {menuName: window.trans('member_reward_point_redemption'), menuFor: "memberRewardPointRedemption",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('member_reward_point_redemption'), menuFor: "memberRewardPointRedemption",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('member_reward_point_redemption.id'),
  name: window.trans('member_reward_point_redemption.name'),
  point: window.trans('member_reward_point_redemption.point'),
  owner: window.trans('member_reward_point_redemption.owner'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'memberRewardPointRedemption') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.point, debugtype: 'int', dataIndex: 'point', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.owner, dataIndex: 'owner', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(memberRewardPointRedemption, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 2
  const userContext = null
  return (
    <div key={memberRewardPointRedemption.id}>
	
      <DescriptionList  key={memberRewardPointRedemption.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{memberRewardPointRedemption.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{memberRewardPointRedemption.name}</Description> 
        <Description term={fieldLabels.point}><div style={{"color":"red"}}>{memberRewardPointRedemption.point}</div></Description> 
        <Description term={fieldLabels.owner}><div>{memberRewardPointRedemption.owner==null?appLocaleName(userContext,"NotAssigned"):`${memberRewardPointRedemption.owner.displayName}(${memberRewardPointRedemption.owner.id})`}
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
const MemberRewardPointRedemptionBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default MemberRewardPointRedemptionBase




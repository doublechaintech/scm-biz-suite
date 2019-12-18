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



const menuData = {menuName: window.trans('sec_user_blocking'), menuFor: "secUserBlocking",
  		subItems: [
  {name: 'secUserList', displayName: window.mtrans('sec_user','sec_user_blocking.sec_user_list',false), type:'secUser',icon:'user',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName: window.trans('sec_user_blocking'), menuFor: "secUserBlocking",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('sec_user_blocking.id'),
  who: window.trans('sec_user_blocking.who'),
  blockTime: window.trans('sec_user_blocking.block_time'),
  comments: window.trans('sec_user_blocking.comments'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'secUserBlocking') , sorter: true },
  { title: fieldLabels.who, debugtype: 'string', dataIndex: 'who', width: '17',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.blockTime, dataIndex: 'blockTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},
  { title: fieldLabels.comments, debugtype: 'string', dataIndex: 'comments', width: '28',render: (text, record)=>renderTextCell(text,record)},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(secUserBlocking,targetComponent)=>{

  const userContext = null
  return (
    <div key={secUserBlocking.id}>
	
      <DescriptionList  key={secUserBlocking.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{secUserBlocking.id}</Description> 
        <Description term={fieldLabels.who} style={{wordBreak: 'break-all'}}>{secUserBlocking.who}</Description> 
        <Description term={fieldLabels.blockTime}><div>{ moment(secUserBlocking.blockTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
        <Description term={fieldLabels.comments} style={{wordBreak: 'break-all'}}>{secUserBlocking.comments}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {who, comments} = formValuesToPack

	const data = {who, comments}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {who, comments} = objectToUnpack

	const data = {who, comments}
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
const SecUserBlockingBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default SecUserBlockingBase




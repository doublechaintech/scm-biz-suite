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


const menuData = {menuName:"用户白名单", menuFor: "userWhiteList",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'ID',
  userIdentity: '用户身份',
  userSpecialFunctions: '用户特殊功能',
  domain: '域',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'userWhiteList') , sorter: true },
  { title: fieldLabels.userIdentity, debugtype: 'string', dataIndex: 'userIdentity', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.userSpecialFunctions, debugtype: 'string', dataIndex: 'userSpecialFunctions', width: '27',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.domain, dataIndex: 'domain', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(userWhiteList,targetComponent)=>{

  const userContext = null
  return (
    <div key={userWhiteList.id}>
	
      <DescriptionList  key={userWhiteList.id} size="small" col="4">
        <Description term="ID">{userWhiteList.id}</Description> 
        <Description term="用户身份">{userWhiteList.userIdentity}</Description> 
        <Description term="用户特殊功能">{userWhiteList.userSpecialFunctions}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const UserWhiteListBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default UserWhiteListBase




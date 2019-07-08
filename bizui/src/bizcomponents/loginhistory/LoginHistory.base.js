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


const menuData = {menuName:"Login History", menuFor: "loginHistory",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'Id',
  loginTime: 'Login Time',
  fromIp: 'From Ip',
  description: 'Description',
  secUser: 'Sec User',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.loginTime, dataIndex: 'loginTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},
  { title: fieldLabels.fromIp, debugtype: 'string', dataIndex: 'fromIp', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.secUser, dataIndex: 'secUser', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(loginHistory,targetComponent)=>{

	
	
	
	const userContext = null
	return (
	<div key={loginHistory.id}>
	
	<DescriptionList  key={loginHistory.id} size="small" col="4">
<Description term="Id">{loginHistory.id}</Description> 
<Description term="Login Time">{ moment(loginHistory.loginTime).format('YYYY-MM-DD')}</Description> 
<Description term="From Ip">{loginHistory.fromIp}</Description> 
<Description term="Description">{loginHistory.description}</Description> 
<Description term="Sec User">{loginHistory.secUser==null?appLocaleName(userContext,"NotAssigned"):`${loginHistory.secUser.displayName}(${loginHistory.secUser.id})`}
</Description>
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const LoginHistoryBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default LoginHistoryBase











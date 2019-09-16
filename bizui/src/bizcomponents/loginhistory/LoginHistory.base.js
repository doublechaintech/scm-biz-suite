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


const menuData = {menuName:"登录历史", menuFor: "loginHistory",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName:"登录历史", menuFor: "loginHistory",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'ID',
  loginTime: '登录时间',
  fromIp: '来自IP',
  description: '描述',
  secUser: '安全用户',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'loginHistory') , sorter: true },
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
        <Description term="ID">{loginHistory.id}</Description> 
        <Description term="登录时间"><div>{ moment(loginHistory.loginTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
        <Description term="来自IP">{loginHistory.fromIp}</Description> 
        <Description term="描述">{loginHistory.description}</Description> 
        <Description term="安全用户"><div>{loginHistory.secUser==null?appLocaleName(userContext,"NotAssigned"):`${loginHistory.secUser.displayName}(${loginHistory.secUser.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const LoginHistoryBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default LoginHistoryBase




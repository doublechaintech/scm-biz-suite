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


const menuData = {menuName:"快速链接", menuFor: "quickLink",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName:"快速链接", menuFor: "quickLink",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'ID',
  name: '名称',
  icon: '图标',
  imagePath: '图片路径',
  linkTarget: '链接的目标',
  createTime: '创建时间',
  app: '应用程序',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'quickLink') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.icon, debugtype: 'string', dataIndex: 'icon', width: '12',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.imagePath, dataIndex: 'imagePath', render: (text, record) => renderImageCell(text,record,'图片路径') },
  { title: fieldLabels.linkTarget, debugtype: 'string', dataIndex: 'linkTarget', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.createTime, dataIndex: 'createTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},
  { title: fieldLabels.app, dataIndex: 'app', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(quickLink,targetComponent)=>{

  const userContext = null
  return (
    <div key={quickLink.id}>
	
      <DescriptionList  key={quickLink.id} size="small" col="4">
        <Description term="ID">{quickLink.id}</Description> 
        <Description term="名称">{quickLink.name}</Description> 
        <Description term="图标">{quickLink.icon}</Description> 
        <Description term="链接的目标">{quickLink.linkTarget}</Description> 
        <Description term="创建时间"><div>{ moment(quickLink.createTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
        <Description term="应用程序"><div>{quickLink.app==null?appLocaleName(userContext,"NotAssigned"):`${quickLink.app.displayName}(${quickLink.app.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const QuickLinkBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default QuickLinkBase




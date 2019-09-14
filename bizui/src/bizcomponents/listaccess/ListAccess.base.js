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


const menuData = {menuName:"访问列表", menuFor: "listAccess",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'ID',
  name: '名称',
  internalName: '内部名称',
  readPermission: '读权限',
  createPermission: '创建权限',
  deletePermission: '删除权限',
  updatePermission: '更新权限',
  executionPermission: '执行权限',
  app: '应用程序',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'listAccess') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.internalName, debugtype: 'string', dataIndex: 'internalName', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.readPermission, dataIndex: 'readPermission', render: (text, record) =>renderBooleanCell(text, record), sorter:true },
  { title: fieldLabels.createPermission, dataIndex: 'createPermission', render: (text, record) =>renderBooleanCell(text, record), sorter:true },
  { title: fieldLabels.deletePermission, dataIndex: 'deletePermission', render: (text, record) =>renderBooleanCell(text, record), sorter:true },
  { title: fieldLabels.updatePermission, dataIndex: 'updatePermission', render: (text, record) =>renderBooleanCell(text, record), sorter:true },
  { title: fieldLabels.executionPermission, dataIndex: 'executionPermission', render: (text, record) =>renderBooleanCell(text, record), sorter:true },
  { title: fieldLabels.app, dataIndex: 'app', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(listAccess,targetComponent)=>{

  const userContext = null
  return (
    <div key={listAccess.id}>
	
      <DescriptionList  key={listAccess.id} size="small" col="4">
        <Description term="ID">{listAccess.id}</Description> 
        <Description term="名称">{listAccess.name}</Description> 
        <Description term="内部名称">{listAccess.internalName}</Description> 
        <Description term="应用程序"><div>{listAccess.app==null?appLocaleName(userContext,"NotAssigned"):`${listAccess.app.displayName}(${listAccess.app.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const ListAccessBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default ListAccessBase




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


const menuData = {menuName:"Object Access", menuFor: "objectAccess",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'Id',
  name: 'Name',
  objectType: 'Object Type',
  list1: 'List1',
  list2: 'List2',
  list3: 'List3',
  list4: 'List4',
  list5: 'List5',
  list6: 'List6',
  list7: 'List7',
  list8: 'List8',
  list9: 'List9',
  app: 'App',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.objectType, debugtype: 'string', dataIndex: 'objectType', width: '32',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.list1, debugtype: 'string', dataIndex: 'list1', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.list2, debugtype: 'string', dataIndex: 'list2', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.list3, debugtype: 'string', dataIndex: 'list3', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.list4, debugtype: 'string', dataIndex: 'list4', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.list5, debugtype: 'string', dataIndex: 'list5', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.list6, debugtype: 'string', dataIndex: 'list6', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.list7, debugtype: 'string', dataIndex: 'list7', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.list8, debugtype: 'string', dataIndex: 'list8', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.list9, debugtype: 'string', dataIndex: 'list9', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.app, dataIndex: 'app', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(objectAccess,targetComponent)=>{

	
	
	
	const userContext = null
	return (
	<div key={objectAccess.id}>
	
	<DescriptionList  key={objectAccess.id} size="small" col="4">
<Description term="Id">{objectAccess.id}</Description> 
<Description term="Name">{objectAccess.name}</Description> 
<Description term="Object Type">{objectAccess.objectType}</Description> 
<Description term="List1">{objectAccess.list1}</Description> 
<Description term="List2">{objectAccess.list2}</Description> 
<Description term="List3">{objectAccess.list3}</Description> 
<Description term="List4">{objectAccess.list4}</Description> 
<Description term="List5">{objectAccess.list5}</Description> 
<Description term="List6">{objectAccess.list6}</Description> 
<Description term="List7">{objectAccess.list7}</Description> 
<Description term="List8">{objectAccess.list8}</Description> 
<Description term="List9">{objectAccess.list9}</Description> 
<Description term="App">{objectAccess.app==null?appLocaleName(userContext,"NotAssigned"):`${objectAccess.app.displayName}(${objectAccess.app.id})`}
</Description>
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const ObjectAccessBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default ObjectAccessBase




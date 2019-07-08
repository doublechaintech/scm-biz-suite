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


const menuData = {menuName:"Sec User Blocking", menuFor: "secUserBlocking",
  		subItems: [
  {name: 'secUserList', displayName:'Sec User', icon:'user',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: 'Id',
  who: 'Who',
  blockTime: 'Block Time',
  comments: 'Comments',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'secUserBlocking') , sorter: true },
  { title: fieldLabels.who, debugtype: 'string', dataIndex: 'who', width: '17',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.blockTime, dataIndex: 'blockTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},
  { title: fieldLabels.comments, debugtype: 'string', dataIndex: 'comments', width: '28',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(secUserBlocking,targetComponent)=>{

	
	
	
	const userContext = null
	return (
	<div key={secUserBlocking.id}>
	
	<DescriptionList  key={secUserBlocking.id} size="small" col="4">
<Description term="Id">{secUserBlocking.id}</Description> 
<Description term="Who">{secUserBlocking.who}</Description> 
<Description term="Block Time">{ moment(secUserBlocking.blockTime).format('YYYY-MM-DD')}</Description> 
<Description term="Comments">{secUserBlocking.comments}</Description> 
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const SecUserBlockingBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default SecUserBlockingBase




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


const menuData = {menuName:"用户屏蔽", menuFor: "secUserBlocking",
  		subItems: [
  {name: 'secUserList', displayName:'安全用户', icon:'user',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: 'ID',
  who: '谁',
  blockTime: '块时间',
  comments: '评论',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'secUserBlocking') , sorter: true },
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
        <Description term="ID">{secUserBlocking.id}</Description> 
        <Description term="谁">{secUserBlocking.who}</Description> 
        <Description term="块时间"><div>{ moment(secUserBlocking.blockTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
        <Description term="评论">{secUserBlocking.comments}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const SecUserBlockingBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default SecUserBlockingBase




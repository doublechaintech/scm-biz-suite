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


const menuData = {menuName:"一级分类", menuFor: "levelOneCategory",
  		subItems: [
  {name: 'levelTwoCategoryList', displayName:'二级分类', icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: '序号',
  catalog: '目录',
  name: '名称',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'levelOneCategory') , sorter: true },
  { title: fieldLabels.catalog, dataIndex: 'catalog', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(levelOneCategory,targetComponent)=>{

  const userContext = null
  return (
    <div key={levelOneCategory.id}>
	
      <DescriptionList  key={levelOneCategory.id} size="small" col="4">
        <Description term="序号">{levelOneCategory.id}</Description> 
        <Description term="目录"><div>{levelOneCategory.catalog==null?appLocaleName(userContext,"NotAssigned"):`${levelOneCategory.catalog.displayName}(${levelOneCategory.catalog.id})`}
        </div></Description>
        <Description term="名称">{levelOneCategory.name}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const LevelOneCategoryBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default LevelOneCategoryBase




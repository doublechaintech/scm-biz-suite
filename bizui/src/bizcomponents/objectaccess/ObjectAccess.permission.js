

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './ObjectAccess.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}
const internalSummaryOf = (objectAccess,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{objectAccess.id}</Description> 
<Description term="名称">{objectAccess.name}</Description> 
<Description term="访问对象类型">{objectAccess.objectType}</Description> 
<Description term="列表1">{objectAccess.list1}</Description> 
<Description term="列表2">{objectAccess.list2}</Description> 
<Description term="列表3">{objectAccess.list3}</Description> 
<Description term="列表4">{objectAccess.list4}</Description> 
<Description term="列表5">{objectAccess.list5}</Description> 
<Description term="列表6">{objectAccess.list6}</Description> 
<Description term="列表7">{objectAccess.list7}</Description> 
<Description term="列表8">{objectAccess.list8}</Description> 
<Description term="列表9">{objectAccess.list9}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = objectAccess => {
  const {ObjectAccessBase} = GlobalComponents
  return <PermissionSetting targetObject={objectAccess}  targetObjectMeta={ObjectAccessBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class ObjectAccessPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  objectAccess = this.props.objectAccess
    const { id,displayName,  } = objectAccess
    const  returnURL = `/objectAccess/${id}/dashboard`
    const cardsData = {cardsName:"对象访问",cardsFor: "objectAccess",cardsSource: objectAccess,displayName,returnURL,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={internalRenderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
      {renderPermissionSetting(cardsData.cardsSource)}
      
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  objectAccess: state._objectAccess,
}))(Form.create()(ObjectAccessPermission))


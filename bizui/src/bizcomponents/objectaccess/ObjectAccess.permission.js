

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
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


const internalSummaryOf = (objectAccess,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
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
    const  objectAccess = this.props.objectAccess;
    const { id,displayName,  } = objectAccess
    const cardsData = {cardsName:"Object Access",cardsFor: "objectAccess",cardsSource: objectAccess,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={`${cardsData.cardsName}: ${displayName}`}
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


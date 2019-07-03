

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
import styles from './OriginalVoucherCreation.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (originalVoucherCreation,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{originalVoucherCreation.id}</Description> 
<Description term="谁">{originalVoucherCreation.who}</Description> 
<Description term="评论">{originalVoucherCreation.comments}</Description> 
<Description term="制造日期">{ moment(originalVoucherCreation.makeDate).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = originalVoucherCreation => {
  const {OriginalVoucherCreationBase} = GlobalComponents
  return <PermissionSetting targetObject={originalVoucherCreation}  targetObjectMeta={OriginalVoucherCreationBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class OriginalVoucherCreationPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  originalVoucherCreation = this.props.originalVoucherCreation;
    const { id,displayName, originalVoucherCount } = originalVoucherCreation
    const cardsData = {cardsName:"原始凭证制作",cardsFor: "originalVoucherCreation",cardsSource: originalVoucherCreation,
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
  originalVoucherCreation: state._originalVoucherCreation,
}))(Form.create()(OriginalVoucherCreationPermission))


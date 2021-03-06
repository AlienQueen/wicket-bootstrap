package de.agilecoders.wicket.markup.html.bootstrap.button;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import de.agilecoders.wicket.markup.html.bootstrap.behavior.CssClassNameAppender;
import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;

import java.util.List;

/**
 * TODO: document
 *
 * @author miha
 * @version 1.0
 */
public class ButtonCssClassAppender extends CssClassNameAppender {
    private static final String DISABLED_CLASSNAME = "btn-disabled";
    private static final String DEFAULT_CLASSNAME = "btn";

    private final IModel<ButtonType> type;
    private final IModel<ButtonSize> size;
    private final IModel<Boolean> block;

    /**
     * Constructor.
     *
     * @param type TODO: document
     * @param size TODO: document
     */
    public ButtonCssClassAppender(IModel<ButtonType> type, IModel<ButtonSize> size, IModel<Boolean> block) {
        super("");

        this.type = type;
        this.size = size;
        this.block = block;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void bind(Component component) {
        super.bind(component);

        getClassNameModel().setObject(Joiner.on(separator()).join(classNames(component.isEnabled())));
    }

    /**
     * @param enabled the enabled state of the assigned component.
     * @return a list of all css class names.
     */
    private List<String> classNames(final boolean enabled) {
        return Lists.newArrayList(DEFAULT_CLASSNAME,
                                  type.getObject().cssClassName(),
                                  size.getObject().cssClassName(),
                                  (block.getObject() ? "btn-block" : ""),
                                  (enabled ? "" : DISABLED_CLASSNAME));
    }

    /**
     * @return a casted instance of the assigned model.
     */
    @SuppressWarnings("unchecked")
    private IModel<String> getClassNameModel() {
        return (IModel<String>) getReplaceModel();
    }
}
